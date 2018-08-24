package com.paracode.mvvmtest.usecase

import com.paracode.mvvmtest.model.Click
import com.paracode.mvvmtest.model.ClickDatabase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface InsertClickUsecase : Usecase<Click> {
    fun initialize(click: Click): InsertClickUsecase
}

class InsertClickUsecaseImpl(
        private val clickDatabase: ClickDatabase
) : InsertClickUsecase {

    private lateinit var click: Click

    override fun initialize(click: Click): InsertClickUsecase {
        this.click = click
        return this
    }

    override fun execute(): Single<Click> =
            Single.just(clickDatabase
                    .clickDao()
                    .insertClick(click))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}