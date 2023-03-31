package namvt.dev.php_project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import namvt.dev.php_project.R
import namvt.dev.php_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fmNavHostGraph)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFm, //These are the ids from nav_graph for each fragment
                R.id.profileFm,
            )
        )

//        setupSmoothBottomMenu()

    }

//    private fun setupSmoothBottomMenu() {
//        val popupMenu = PopupMenu(this,null)
//        popupMenu.inflate(R.menu.menu)
//        val menu = popupMenu.menu
//        binding.navBot.setupWithNavController(menu, navController)
//    }
//
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}

