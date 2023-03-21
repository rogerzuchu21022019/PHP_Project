package namvt.dev.php_project.fragments.forgotPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import namvt.dev.php_project.R
import namvt.dev.php_project.databinding.FmForgotPasswordBinding
import namvt.dev.php_project.databinding.FmSignUpBinding

class ForgotPasswordFm : Fragment() {
    private lateinit var binding: FmForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

}