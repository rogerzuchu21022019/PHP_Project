package namvt.dev.php_project.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import namvt.dev.php_project.R

import namvt.dev.php_project.databinding.FmHomeBinding

class HomeFm : Fragment() {
    private lateinit var binding: FmHomeBinding

    lateinit var navController:NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmHomeBinding.inflate(layoutInflater)
        navController = requireActivity().findNavController(R.id.fmNavHostGraph)
        setupSmoothBottomMenu()
        return binding.root
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(requireActivity().applicationContext,null)
        popupMenu.inflate(R.menu.menu)
        val menu = popupMenu.menu
        binding.navBot.setupWithNavController(menu, navController)
    }





}