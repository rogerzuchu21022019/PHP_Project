package namvt.dev.php_project.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import namvt.dev.php_project.R
import namvt.dev.php_project.databinding.FmProfileBinding

class ProfileFM : Fragment() {
    private lateinit var binding: FmProfileBinding

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmProfileBinding.inflate(layoutInflater)
        navController = requireActivity().findNavController(R.id.fmNavHostGraph)
        setupSmoothBottomMenu()
        clickButton();
        return binding.root
    }

    private fun clickButton() {
        binding.btnSignOut.apply {
            setOnClickListener {
                val action = ProfileFMDirections.actionProfileFmToSignInFm()
                findNavController().navigate(action)
            }
        }
    }



    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(requireActivity().applicationContext,null)
        popupMenu.inflate(R.menu.menu)
        val menu = popupMenu.menu
        binding.navBot.setupWithNavController(menu, navController)
    }




}