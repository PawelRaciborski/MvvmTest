package com.paracode.mvvmtest

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Pawel Raciborski on 20.08.2018.
 */

class MainViewModel(
        val text: MutableLiveData<String> = MutableLiveData()
) : ViewModel() {

    private var counter: Int = 12

    init {
        text.postValue(counter.toString())
    }

    fun onClick() {
        counter++
        text.postValue(counter.toString())
    }
}