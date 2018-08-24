package com.paracode.mvvmtest.usecase

import io.reactivex.Single

interface Usecase<T> {
    fun execute(): Single<T>
}