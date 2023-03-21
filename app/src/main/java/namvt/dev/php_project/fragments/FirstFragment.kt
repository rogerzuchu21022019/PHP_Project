package namvt.dev.php_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import com.squareup.picasso.Picasso
import namvt.dev.php_project.databinding.FmFirstBinding

public class FirstFragment : Fragment() {
    private lateinit var binding: FmFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmFirstBinding.inflate(layoutInflater)
        clickButton()
        loadImage(binding.ivInternet)
        return binding.root
    }

    public fun loadImage(iv:ImageView) {
        var uri =
            "https://thpt-phamhongthai.edu.vn/wp-content/uploads/2022/07/hinh-anh-hot-girl-xinh-han-quoc-wap102-com2b252812529.jpg"
        Picasso.get().load(uri).into(iv)
    }

    private fun clickButton() {

        binding.btnLoadImage.apply {
            setOnClickListener {
                loadImage(binding.ivLoadInternet)
            }
        }

        binding.btnBai3.apply {
            setOnClickListener {
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
                findNavController().navigate(action)
            }
        }
    }

}