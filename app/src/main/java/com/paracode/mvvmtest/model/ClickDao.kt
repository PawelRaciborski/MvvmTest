package com.paracode.mvvmtest.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface ClickDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClick(click: Click): Click

    @Query("SELECT * from click")
    fun getAllClicks(): Flowable<List<Click>>
}