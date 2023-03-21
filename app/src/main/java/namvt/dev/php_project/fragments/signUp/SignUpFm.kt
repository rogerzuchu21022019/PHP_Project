package namvt.dev.php_project.fragments.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import namvt.dev.php_project.databinding.FmSignUpBinding
import namvt.dev.php_project.fragments.signIn.SignInFmDirections

class SignUpFm : Fragment() {
    private lateinit var binding: FmSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmSignUpBinding.inflate(layoutInflater)
        clickButton()
        return binding.root
    }

    private fun clickButton() {
        binding.btnSignUp.apply {
            setOnClickListener {
                moveToSignIn()
            }
        }

        binding.btnLogin.apply {
            setOnClickListener {
                moveToSignIn()
            }
        }
    }

    fun moveToSignIn() {
        val action = SignUpFmDirections.actionSignUpFmToSignInFm()
        findNavController().navigate(action)
    }

}