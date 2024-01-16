package com.nexis.mobilapp3.fragments

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.nexis.mobilapp3.R
import com.nexis.mobilapp3.databinding.FragmentSignInBinding
import com.nexis.mobilapp3.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentSplashBinding.inflate(inflater)
        playlottie()
        return binding.root
    }


    private fun playlottie(){
        binding.animationView.repeatCount=0
        binding.animationView.playAnimation()

        binding.animationView.addAnimatorListener(object:AnimatorListener{
            override fun onAnimationStart(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {
                openApp()
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }


        })

    }

    private fun openApp() {
        val action = SplashFragmentDirections.actionSplashFragmentToSignUpFragment()
        findNavController().navigate(action)
    }
}