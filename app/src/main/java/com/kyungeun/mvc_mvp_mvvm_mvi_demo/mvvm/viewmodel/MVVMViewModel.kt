package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.Event
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.model.Memo


class MVVMViewModel : ViewModel() {

    private var _liveData = MutableLiveData<Memo>()
    val liveData : LiveData<Memo>
        get() = _liveData

    private val _openEvent = MutableLiveData<Event<Memo>>()
    val openEvent: LiveData<Event<Memo>>
        get() = _openEvent

    init {
        _liveData.value = Memo("a","b")
    }

    fun submit(memo: Memo) {
        _liveData.postValue(memo)
        _openEvent.value = Event(memo)
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

