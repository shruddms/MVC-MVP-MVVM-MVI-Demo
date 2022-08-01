package com.kyungeun.mvc_mvp_mvvm_mvi_demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMainBinding
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvc.controller.MVCActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvi.MVIActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.view.MVPActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.view.MVVMActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mvcBtn.setOnClickListener(this)
        binding.mvpBtn.setOnClickListener(this)
        binding.mvvmBtn.setOnClickListener(this)
        binding.mviBtn.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.mvcBtn -> {
                val mvcIntent = Intent(this, MVCActivity::class.java)
                startActivity(mvcIntent)
            }
            R.id.mvpBtn -> {
                val mvpIntent = Intent(this, MVPActivity::class.java)
                startActivity(mvpIntent)
            }
            R.id.mvvmBtn -> {
                val mvvmIntent = Intent(this, MVVMActivity::class.java)
                startActivity(mvvmIntent)
            }
            R.id.mviBtn -> {
                val mviIntent = Intent(this, MVIActivity::class.java)
                startActivity(mviIntent)
            }
        }
    }
}