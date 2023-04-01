package namvt.dev.php_project.fragments.signUp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import namvt.dev.php_project.databinding.FmSignUpBinding
import namvt.dev.php_project.fragments.signIn.SignInFmDirections
import namvt.dev.php_project.models.users.User
import namvt.dev.php_project.network.API
import namvt.dev.php_project.network.APIService

class SignUpFm : Fragment() {
    private lateinit var binding: FmSignUpBinding
    private var apiService: APIService = API.getAPI().create(APIService::class.java)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FmSignUpBinding.inflate(layoutInflater)
        clickButton()
        return binding.root
    }

    private fun clickButton() {
        binding.btnSignUp.apply {
            setOnClickListener {
                val email = binding.tieUsername.text.toString().trim()
                val password = binding.tiePassWord.text.toString().trim()
                onSignUp(email, password)
            }
        }

        binding.btnLogin.apply {
            setOnClickListener {
                moveToSignIn()
            }
        }
    }

    fun onSignUp(email:String, password:String){
        GlobalScope.launch(Dispatchers.IO){
            val user = User(email= email,password=password,"","",0)
            val response = apiService.signUp(user)
            if(response.isSuccessful){
                withContext(Dispatchers.Main){
                    Toast.makeText(requireContext(),"${response.body()!!.email.toString()} Sign Up Success", Toast.LENGTH_SHORT).show()
                    moveToSignIn()
                }
            }
        }

    }

    fun moveToSignIn() {
        val action = SignUpFmDirections.actionSignUpFmToSignInFm()
        findNavController().navigate(action)
    }

}