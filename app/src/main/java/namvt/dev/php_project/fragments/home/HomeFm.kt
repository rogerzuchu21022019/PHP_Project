package namvt.dev.php_project.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import namvt.dev.php_project.databinding.FmForgotPasswordBinding
import namvt.dev.php_project.databinding.FmHomeBinding

class HomeFm : Fragment() {
    private lateinit var binding: FmHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmHomeBinding.inflate(layoutInflater)
        return binding.root
    }

}