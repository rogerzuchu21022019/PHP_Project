package namvt.dev.php_project.fragments.signIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import namvt.dev.php_project.R
import namvt.dev.php_project.databinding.FmSignInBinding
import namvt.dev.php_project.databinding.FmSignUpBinding

class SignInFm : Fragment() {
    private lateinit var binding: FmSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmSignInBinding.inflate(layoutInflater)
        clickButton()
        return binding.root
    }

    private fun clickButton() {
        binding.btnSignIn.apply {
            setOnClickListener {
                moveToHome()
            }
        }

        binding.btnSignUp.apply {
            setOnClickListener {
                moveToSignUp()
            }
        }
        binding.btnForgot.apply {
            setOnClickListener {
                moveToForgot()
            }
        }
    }

    fun moveToSignUp() {
        val action = SignInFmDirections.actionSignInFmToSignUpFm()
        findNavController().navigate(action)
    }

    fun moveToHome() {
        val action = SignInFmDirections.actionSignInFmToHomeFm()
        findNavController().navigate(action)
    }

    fun moveToForgot() {
        val action = SignInFmDirections.actionSignInFmToForgotPasswordFm()
        findNavController().navigate(action)
    }

}