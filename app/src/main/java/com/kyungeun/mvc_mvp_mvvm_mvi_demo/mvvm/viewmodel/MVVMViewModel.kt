package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel

import android.content.Intent
import androidx.lifecycle.*
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.model.Memo
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.view.MVVMResultActivity


class MVVMViewModel : ViewModel() {

//    private val memo = MutableLiveData<Memo>()

    var memo = MutableLiveData<Memo>()





    private val _openEvent = MutableLiveData<Event<Memo>>()
    val openEvent: LiveData<Event<Memo>> get() = _openEvent



    val liveData: LiveData<Memo>
        get() = memo

//    val title = MutableLiveData<String>()
//    val contents = MutableLiveData<String>()

    fun onClickEvent(memo: Memo) {
        _openEvent.value = Event(memo)
    }










//    fun loadData() = viewModelScope.launch {
//        _liveData.value = Memo("title","contents")
//    }

//    fun setMemo(title: String, contents: String) {
//        _liveData.postValue(Memo(title,contents))
//    }

    fun submit(title: String, contents: String) {

    }

}

inline fun <T> LiveData<Event<T>>.eventObserve(
    owner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
): Observer<Event<T>> {
    val wrappedObserver = Observer<Event<T>> { t ->
        t.getContentIfNotHandled()?.let {
            onChanged.invoke(it)
        }
    }
    observe(owner, wrappedObserver)
    return wrappedObserver
}