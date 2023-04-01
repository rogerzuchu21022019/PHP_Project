package namvt.dev.php_project.fragments.signIn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import namvt.dev.php_project.databinding.FmSignInBinding
import namvt.dev.php_project.models.users.User
import namvt.dev.php_project.models.users.UserViewModel
import namvt.dev.php_project.network.API
import namvt.dev.php_project.network.APIService

class SignInFm : Fragment() {
    private lateinit var binding: FmSignInBinding
    var apiService: APIService = API.getAPI().create(APIService::class.java)

    //    lateinit var userViewModel: UserViewModel
//    private val userViewModel: UserViewModel by viewModels()
    val userViewModel: UserViewModel by activityViewModels()

    //    val userViewModel =
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmSignInBinding.inflate(layoutInflater)
        clickButton()
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
//        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }


    private fun clickButton() {
        binding.btnSignIn.apply {
            setOnClickListener {

                val email = binding.tieUsername.text.toString().trim()
                val password = binding.tiePassWord.text.toString().trim()

                val user = User(email = email, password = password, "", "", 0)
                lifecycleScope.launch {
                    val response = withContext(Dispatchers.IO) {
                        apiService.signIn(user)

                    }
                    if (response.isSuccessful) {
                        val userResult = response.body()!!
                        Log.d("SIGN IN FM", "ok ${userResult}")

                        userViewModel.setUser(userResult)
                        val currentUser =
                            userViewModel.user.value // => get value of user from userViewModel.user
                        Log.d("SIGN IN FM", "current user ${currentUser}")
                        moveToHome(currentUser!!)
                    }

                }
//                moveToHome()
            }
        }

        binding.btnSignUp.apply {
            setOnClickListener {
                moveToSignUp()
            }
        }
        binding.btnForgot.apply {
            setOnClickListener {
                moveToForgot()
            }
        }
    }

    fun moveToSignUp() {
        val action = SignInFmDirections.actionSignInFmToSignUpFm()
        findNavController().navigate(action)
    }

    fun moveToHome(user: User) {
        val action = SignInFmDirections.actionSignInFmToHomeFm(user)
        findNavController().navigate(action)
    }

    fun moveToForgot() {
        val action = SignInFmDirections.actionSignInFmToForgotPasswordFm()
        findNavController().navigate(action)
    }

}