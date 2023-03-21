package namvt.dev.php_project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import namvt.dev.php_project.R
import namvt.dev.php_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}