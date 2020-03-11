package com.example.livedata.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.R
import com.example.livedata.common.BaseFragment
import com.example.livedata.list.ListActivity
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

class LoginFragment : BaseFragment(), View.OnClickListener{

    @Inject
    lateinit var loginViewModelFactory: LoginViewModel.LoginViewModelFactory
    private val loginViewModel : LoginViewModel by lazy {
        ViewModelProvider(this,loginViewModelFactory).get(LoginViewModel::class.java)
    }

    companion object {
        fun newInstance() = LoginFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button ->{
                loginViewModel.validateInputs(
                    editTextEmail.text.toString().trim(),
                    editTextPassword.text.toString().trim()
                ).observe(this, Observer {
                    val intent = Intent(context, ListActivity::class.java)
                    startActivity(intent)
                })
            }
        }
    }

}
