package namvt.dev.php_project.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import namvt.dev.php_project.R
import namvt.dev.php_project.databinding.FragmentDetailBinding


class DetailFM : Fragment() {
    lateinit var binding: FragmentDetailBinding
    val navArgs: DetailFMArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        onClickButton()
        onUpdateUI()
        return binding.root
    }

    private fun onClickButton() {
        binding.back.apply {
            setOnClickListener {
                val action = DetailFMDirections.actionDetailFMToHomeFm()
                findNavController().navigate(action)
            }
        }
    }


    private fun onUpdateUI() {
        binding.news = navArgs.news
        binding.user = navArgs.user
        binding.category = navArgs.category

    }


}