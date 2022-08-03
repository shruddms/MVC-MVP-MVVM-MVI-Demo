package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.MainActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMvvmResultBinding

class MVVMResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_result)
        binding.activity = this@MVVMResultActivity

        binding.title = intent.extras?.get("title") as String
        binding.contents = intent.extras?.get("contents") as String
    }

    fun nextActivity() {
        val mainIntent = Intent(this, MainActivity::class.java)
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(mainIntent)
    }
}
