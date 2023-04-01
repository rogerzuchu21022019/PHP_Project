package namvt.dev.php_project.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jaredrummler.materialspinner.MaterialSpinner
import namvt.dev.php_project.databinding.FragmentAddNewsBinding
import namvt.dev.php_project.databinding.FragmentUpdateProfileBinding


class UpdateProfileFM : Fragment() {
    lateinit var binding: FragmentUpdateProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateProfileBinding.inflate(layoutInflater)
        onClickButton()
        onUpdateUI()
        return binding.root
    }

    private fun onClickButton() {
        binding.ivClose.apply {
            setOnClickListener {
                val action = UpdateProfileFMDirections.actionUpdateProfileFMToProfileFm()
                findNavController().navigate(action)
            }
        }

        binding.ivDone.apply {
            setOnClickListener {
                val action = UpdateProfileFMDirections.actionUpdateProfileFMToProfileFm()
                findNavController().navigate(action)
            }
        }

        binding.btnSignOut.apply {
            setOnClickListener {
                val action = UpdateProfileFMDirections.actionUpdateProfileFMToSignInFm()
                findNavController().navigate(action)
            }
        }

    }


    private fun onUpdateUI() {


    }


}