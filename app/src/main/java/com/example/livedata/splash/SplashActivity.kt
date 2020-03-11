package com.example.livedata.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.R
import com.example.livedata.auth.AuthActivity
import com.example.livedata.common.BaseActivity
import com.example.livedata.list.ListActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {


    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec

    @Inject
    lateinit var viewModelFactory: SplashViewModel.SplashViewModelFactory
    val splashViewModel: SplashViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            isUserIsLoggedIn()
            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }

    private fun isUserIsLoggedIn() {
        splashViewModel.checkUserCredentials().observe(this, Observer {
            if (it){
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

    }
}
