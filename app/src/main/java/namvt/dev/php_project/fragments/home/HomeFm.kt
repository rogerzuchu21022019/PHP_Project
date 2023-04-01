package namvt.dev.php_project.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import namvt.dev.php_project.R
import namvt.dev.php_project.adapter.NewsAdapter

import namvt.dev.php_project.databinding.FmHomeBinding
import namvt.dev.php_project.models.categories.Category
import namvt.dev.php_project.models.news.News
import namvt.dev.php_project.models.users.User
import namvt.dev.php_project.models.users.UserViewModel
import namvt.dev.php_project.network.API
import namvt.dev.php_project.network.APIService

class HomeFm : Fragment(), NewsAdapter.OnClickItemInRecyclerView {
    private lateinit var binding: FmHomeBinding
    lateinit var news: News
    lateinit var navController: NavController
    lateinit var adapter: NewsAdapter
    var apiService: APIService = API.getAPI().create(APIService::class.java)

    val navArgs: HomeFmArgs by navArgs()

    val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FmHomeBinding.inflate(layoutInflater)
        navController = requireActivity().findNavController(R.id.fmNavHostGraph)
        setupSmoothBottomMenu()
        onClickButton();
        onLoadData()
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
        userViewModel.user.observe(viewLifecycleOwner) {
            Log.d("user_fix", "${it.userId} ${it.email} ${it.imageUrl} ${it.password}")
        }
    }

    private fun onLoadData() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                var response = apiService.findNewsList()
                var responseCate = apiService.findNewsCategories()
                var responseUser = apiService.findUsers()
                if (response.isSuccessful) {
                    val mulNewsList = response.body()!!
                    val mulCate = responseCate.body()!!
                    val mulUsers = responseUser.body()!!
                    Log.d("HOME_FM", "mulUsers ${mulUsers[0].imageUrl}")
                    Log.d("Loading", "tententen ${userViewModel.user.value}")


                    lifecycleScope.launch {
                        Log.d("Loading", "${userViewModel.user.value}")
                        adapter = NewsAdapter()
                        binding.rvItemNews.adapter = adapter
//                    adapter.setAdapter(mulNewsList, category,user)
                        adapter.setAdapter(mulNewsList, mulCate, mulUsers)
                        binding.rvItemNews.setHasFixedSize(true)
                        adapter.setOnClickItem(this@HomeFm)
                    }
                }
            }

        }
    }


    private fun onClickButton() {
        Log.d("onClickButton", "Click ${navArgs.user!!}")
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(requireActivity().applicationContext, null)
        popupMenu.inflate(R.menu.menu)
        val menu = popupMenu.menu
        binding.navBot.setupWithNavController(menu, navController)
    }

    override fun onItemClick(position: Int, view: View) {
//        Toast.makeText(requireContext(), "position:${position},", Toast.LENGTH_LONG).show()

        var news = adapter.getNews(position)
        var user = adapter.getUser(position)
        var category = adapter.getCategory(position)
        onMoveTo(news, user, category)

    }

    fun onMoveTo(news: News, user: User, category: Category) {
        val action = HomeFmDirections.actionHomeFmToDetailFM(news, user, category)
        findNavController().navigate(action)
    }


}