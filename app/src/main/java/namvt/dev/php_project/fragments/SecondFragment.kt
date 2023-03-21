package namvt.dev.php_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import namvt.dev.php_project.databinding.FmSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FmSecondBinding
    private lateinit var job:Job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmSecondBinding.inflate(layoutInflater)
        clickButton()
        return binding.root
    }


    private fun clickButton() {
//
        binding.btnBai3.apply {
            setOnClickListener {
                var time = binding.edtTime.text.toString().trim()
                val timeResult = time.toIntOrNull()

                if (timeResult != null && timeResult > 0) {
                    job = CoroutineScope(Dispatchers.Default).launch {
                        delay(timeResult * 1000L)
                        withContext(Dispatchers.Main) {
                            binding.tvResult.text = "Finished after $timeResult seconds"
                        }
                    }
                } else {
                    binding.tvResult.text = "Please enter a valid number of seconds"
                }
            }
        }
        binding.btnNext.apply {
            setOnClickListener {
                val action = SecondFragmentDirections.actionSecondFragmentToCalculatorFragment6()
                findNavController().navigate(action)
            }
        }
    }

}