package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter

import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.model.Memo

class MVPPresenter(view: Contract.View) : Contract.Presenter {
    var view: Contract.View
    var memo: Memo


    init {
        this.view = view //Activty View정보 가져와 통신
        memo = Memo(this) //Model 객체 생성
    }
}