package com.paracode.mvvmtest.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(
        entities = [Click::class],
        version = 1
)
abstract class ClickDatabase : RoomDatabase() {
    companion object {
        private var instance: ClickDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ClickDatabase? {
            if (instance == null) {
                instance = Room
                        .databaseBuilder(
                                context.applicationContext,
                                ClickDatabase::class.java,
                                "click.db")
                        .allowMainThreadQueries()
                        .build()
            }

            return instance
        }
    }

    abstract fun clickDao(): ClickDao
}