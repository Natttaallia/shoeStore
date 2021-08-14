package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * @author Kulbaka Nataly
 * @date 17.07.2021
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.signInBtn.setOnClickListener {
            if (inputEmpty(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
            ) {
                Toast.makeText(context, getString(R.string.empty_imput), Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        binding.signUpBtn.setOnClickListener {
            if (inputEmpty(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
            ) {
                Toast.makeText(context, getString(R.string.empty_imput), Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        return binding.root
    }

    private fun inputEmpty(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }
}