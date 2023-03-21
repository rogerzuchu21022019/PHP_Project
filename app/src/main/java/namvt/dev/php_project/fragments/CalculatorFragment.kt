package namvt.dev.php_project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import namvt.dev.php_project.databinding.FmCalculatorBinding
import namvt.dev.php_project.network.API
import namvt.dev.php_project.network.APIService


class CalculatorFragment : Fragment() {
    private lateinit var binding: FmCalculatorBinding
    private lateinit var job: Job
    var apiService: APIService = API.getAPI().create(APIService::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmCalculatorBinding.inflate(layoutInflater)
        clickButton()
        return binding.root
    }


    private fun clickButton() {
        binding.btnGet.apply {
            setOnClickListener {
                getResult()
            }
        }
        binding.btnNext.apply {
            setOnClickListener {
                gotoNext()
            }
        }
    }

    fun getResult(){
        GlobalScope.launch(Dispatchers.Main){
            val response = apiService.getResult(a = 4,b=-3,c=-1)
            if (response.isSuccessful){

                val responseBody = response.body()
                binding.tvResult.text = "Result : ${responseBody?.status.toString().trim()}"
                binding.tvResult1.text = "X1= ${responseBody?.x1.toString().trim()}"
                binding.tvResult2.text = "X2= ${responseBody?.x2.toString().trim()}"
            }
        }
    }

    fun gotoNext(){
        val action = CalculatorFragmentDirections.actionCalculatorFragmentToFourthFragment()
        findNavController().navigate(action)
    }


}