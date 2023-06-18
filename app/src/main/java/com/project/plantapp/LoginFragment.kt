package com.project.plantapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.project.plantapp.databinding.FragmentLoginBinding
import com.project.plantapp.databinding.FragmentSignupBinding
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.signInBtn.setOnClickListener{
            val email = binding.signUpEmail.text.toString()
            val password = binding.signUpConfirmPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Login successful
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        } else {
                            // Login failed, display error message
                            val errorMessage = task.exception?.message
                            // Handle the error message as per your requirements
                        }
                    }
            } else {
                Toast.makeText(requireContext(), "Email and password are required", Toast.LENGTH_SHORT).show()
            }

        }
        binding.signUpBtn.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        binding.forgotPassword.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        return binding.root
    }

}