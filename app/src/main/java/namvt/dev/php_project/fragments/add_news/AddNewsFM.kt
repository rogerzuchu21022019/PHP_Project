package namvt.dev.php_project.fragments.add_news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import namvt.dev.php_project.databinding.FragmentAddNewsBinding
import namvt.dev.php_project.models.news.News
import namvt.dev.php_project.models.users.UserViewModel
import namvt.dev.php_project.network.API
import namvt.dev.php_project.network.APIService
import kotlin.math.log


class AddNewsFM : Fragment() {
    lateinit var binding: FragmentAddNewsBinding
    private var apiService: APIService = API.getAPI().create(APIService::class.java)

        lateinit var userViewModel: UserViewModel

    var categoryId: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewsBinding.inflate(layoutInflater)
        onClickButton()
        onUpdateUI()
        onLoadData()
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.user.observe(viewLifecycleOwner) {
            Log.d("Loading","${it}")
        }
    }

    private fun onClickButton() {
        binding.back.apply {
            setOnClickListener {
                val action = AddNewsFMDirections.actionAddNewsFMToProfileFm()
                findNavController().navigate(action)

            }
        }

        binding.btnPublish.apply {
            setOnClickListener {
//                val action = AddNewsFMDirections.actionAddNewsFMToProfileFm()
//                findNavController().navigate(action)
                GlobalScope.launch(Dispatchers.Main){
                    Snackbar.make(requireView(),"${userViewModel.user.value}",Snackbar.LENGTH_SHORT).show()
                }

                val newsDescription = binding.edtNewsDescription.text.toString().trim()
                val newsTitle = binding.edtNewsTitle.text.toString().trim()
//                Snackbar.make(requireView(),"${categoryId}",Snackbar.LENGTH_SHORT).show()
//                val news = News(
//                    categoryId=categoryId,
//                    imageUrl = "https://th.bing.com/th/id/OIP.KIpTSnziUEHB7HjjhB6pnwHaF7?w=219&h=180&c=7&r=0&o=5&dpr=2&pid=1.7",
//                    title =  newsTitle,
//                    newsDescription =  newsDescription,
//                    newsId = 0,
//                    userId = 0,
//                )
            }
        }

        binding.spinner.setOnItemSelectedListener(MaterialSpinner.OnItemSelectedListener<String> { view, position, id, item ->
            val arr = item!!.toString().split(".")
            categoryId = arr[0].toInt()
        })
    }


    private fun onUpdateUI() {


    }

    fun onLoadData() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = apiService.findNewsCategories()
            if (response.isSuccessful) {
                val mulCategories = response.body()!!
                val newCategory = mulCategories.map {
                    it.cId.toString() + "." + it.cName
                }
                withContext(Dispatchers.Main) {
                    binding.spinner.setItems(newCategory)
                }
            }
        }
    }


}