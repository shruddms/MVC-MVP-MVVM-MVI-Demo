package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter

interface Contract {
    interface View {
        fun nextActivity(answer: Int)
    }

    interface Presenter {

    }
}