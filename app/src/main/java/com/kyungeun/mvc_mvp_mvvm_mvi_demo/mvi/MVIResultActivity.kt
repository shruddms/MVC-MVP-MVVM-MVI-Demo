package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.MainActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMviResultBinding

class MVIResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMviResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvi_result)
        binding.activity = this@MVIResultActivity

        binding.title =  intent.extras?.get("title") as String
        binding.contents =  intent.extras?.get("contents") as String
    }

    fun nextActivity() {
        val mainIntent = Intent(this, MainActivity::class.java)
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(mainIntent)
    }
}