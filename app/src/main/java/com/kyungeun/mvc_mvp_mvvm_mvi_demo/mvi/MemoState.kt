package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvi

data class MemoState(
    val title: String = "",
    val contents: String = ""
)

sealed class MemoStateSideEffect {
    data class Submit(val title: String, val contents: String) : MemoStateSideEffect()
}
