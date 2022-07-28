package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.model

import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter.Contract

class Memo(presenter: Contract.Presenter) {
    var presenter: Contract.Presenter

    init {
        this.presenter = presenter
    }
}
