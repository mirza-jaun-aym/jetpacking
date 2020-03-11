package com.example.livedata.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livedata.R
import kotlinx.android.synthetic.main.activity_injection_experiment.*
import javax.inject.Inject

class InjectionExperimentActivity : AppCompatActivity() {
    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_injection_experiment)
        DaggerAppComponent.create().inject(this)
        textViewTitle.text = info.text
    }
}
