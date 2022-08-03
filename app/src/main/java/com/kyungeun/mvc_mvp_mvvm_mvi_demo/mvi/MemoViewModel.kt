package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MemoViewModel : ContainerHost<MemoState, MemoStateSideEffect>, ViewModel() {

    override val container = container<MemoState, MemoStateSideEffect>(MemoState())

    fun submit(title: String, contents: String) = intent {
        postSideEffect(MemoStateSideEffect.Submit(title,contents))

        reduce {
            state.copy(title = state.title, contents = state.contents)
        }
    }
}