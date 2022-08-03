package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter

import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.model.Memo

class MVPPresenter(view: Contract.View) : Contract.Presenter {
    var view: Contract.View
    var memo: Memo

    init {
        this.view = view
        memo = Memo(this)
    }

    override fun setMemo(title: String, contents: String) {
        view.nextActivity(title, contents)
    }
}
