package namvt.dev.php_project.fragments.edit_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jaredrummler.materialspinner.MaterialSpinner
import namvt.dev.php_project.databinding.FragmentAddNewsBinding
import namvt.dev.php_project.databinding.FragmentEditNewsBinding


class EditNewsFM : Fragment() {
    lateinit var binding: FragmentEditNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNewsBinding.inflate(layoutInflater)
        onClickButton()
        onUpdateUI()
        return binding.root
    }

    private fun onClickButton() {
        binding.back.apply {
            setOnClickListener {
//                val action = FragmentEditNewsBinding.actionAddNewsFMToProfileFm()
//                findNavController().navigate(action)
            }
        }

        binding.btnPublish.apply {
            setOnClickListener {
//                val action = AddNewsFMDirections.actionAddNewsFMToProfileFm()
//                findNavController().navigate(action)
            }
        }
        binding.spinner.setItems("Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow");
        binding.spinner.setOnItemSelectedListener(MaterialSpinner.OnItemSelectedListener<String> { view, position, id, item ->
            Snackbar.make(
                view,
                "Clicked $item",
                Snackbar.LENGTH_LONG
            ).show()
        })
    }


    private fun onUpdateUI() {


    }


}