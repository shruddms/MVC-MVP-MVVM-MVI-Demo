package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter

interface Contract {
    interface View {
        fun nextActivity(title: String, contents: String)
    }

    interface Presenter {
        fun setMemo(title: String, contents: String)
    }
}
