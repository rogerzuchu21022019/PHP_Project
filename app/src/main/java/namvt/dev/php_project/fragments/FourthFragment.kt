package namvt.dev.php_project.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import namvt.dev.php_project.databinding.FmFourthBinding
import namvt.dev.php_project.models.Post
import namvt.dev.php_project.models.Result
import namvt.dev.php_project.network.API
import namvt.dev.php_project.network.APIService

class FourthFragment : Fragment() {
    private lateinit var binding: FmFourthBinding
    val apiService: APIService = API.getAPI().create(APIService::class.java)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmFourthBinding.inflate(layoutInflater)
        clickButton()
        return binding.root
    }

    fun clickButton() {
        binding.btnCalculate.apply {
            setOnClickListener {
                calculate()
            }
        }
    }

    fun calculate() {


        GlobalScope.launch(Dispatchers.Main) {
            var stringA = binding.edtPressA.text.trim().toString()
            var stringB = binding.edtPressB.text.trim().toString()
            var stringC = binding.edtPressC.text.trim().toString()
            Log.d("a", stringA)

            withContext(Dispatchers.IO) {
                val post = Post(a = stringA.toDouble(),b = stringB.toDouble(),c = stringC.toDouble())
                val response =
                    apiService.calculate(post)
                if (response.isSuccessful) {
                    val result = response.body()
                    withContext(Dispatchers.Main) {
                       binding.tvResult.text = "Result = ${result?.result.toString().trim()}"
                       binding.tvStatus.text = "Status: ${result?.status.toString().trim()}"
                    }
                }
            }
        }

    }


}