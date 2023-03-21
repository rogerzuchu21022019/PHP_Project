package namvt.dev.php_project.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import namvt.dev.php_project.databinding.FmSplashBinding
import namvt.dev.php_project.fragments.FirstFragment

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: FmSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FmSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirstFragment().loadImage(binding.ivScreen)
        navDirection()

    }



    private fun navDirection() {
        var handler = Handler(Looper.myLooper()!!)
        handler.postDelayed(Runnable {
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}