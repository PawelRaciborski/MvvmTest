package com.paracode.mvvmtest.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Click (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    var timestamp: String
)