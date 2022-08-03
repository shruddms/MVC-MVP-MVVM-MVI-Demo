package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMviBinding
import org.orbitmvi.orbit.viewmodel.observe

class MVIActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMviBinding

    private val viewModel: MemoViewModel by lazy {
        ViewModelProvider(this)[MemoViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            viewModel.submit(binding.titleEditText.text.toString(),binding.contentsEditText.text.toString())
        }

        viewModel.observe(lifecycleOwner = this, state = ::render, sideEffect = ::handleSideEffect)
    }

    private fun render(state: MemoState) {
    }

    private fun handleSideEffect(sideEffect: MemoStateSideEffect) {
        when (sideEffect) {
            is MemoStateSideEffect.Submit
            -> {
                val resultIntent = Intent(this, MVIResultActivity::class.java)
                resultIntent.putExtra("title",sideEffect.title)
                resultIntent.putExtra("contents",sideEffect.contents)
                startActivity(resultIntent)
            }
        }
    }
}