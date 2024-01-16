package com.nexis.mobilapp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.nexis.mobilapp3.R

import com.nexis.mobilapp3.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {




    private lateinit var auto: FirebaseAuth
    private lateinit var navController: NavController
    private lateinit var binding: FragmentSignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registerEvents()

    }


    private fun init(view: View){

        navController= Navigation.findNavController(view)
        auto=FirebaseAuth.getInstance()


    }
    private fun registerEvents(){



        binding.textview32.setOnClickListener {
            findNavController().popBackStack()

        }


        binding.btn.setOnClickListener {
            val email= binding.emailEt.text.toString().trim()
            val password=binding.passEt.text.toString().trim()



            if (email.isNotEmpty()&&password.isNotEmpty()){

                    auto.createUserWithEmailAndPassword(email,password).addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(context,"Login Successfully", Toast.LENGTH_SHORT).show()
                                navController.navigate(R.id.action_signUpFragment_to_signInFragment)

                            }else{
                                Toast.makeText(context,it.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    )

            }
        }
    }


}


