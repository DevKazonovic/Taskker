package com.devkazonovic.projects.mytasks.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devkazonovic.projects.mytasks.data.local.db.TasksDataBase
import com.devkazonovic.projects.mytasks.data.local.preference.IMainSharedPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideTaskDataBase(
        @ApplicationContext context: Context,
        sharedPreferences: IMainSharedPreference,
    ): TasksDataBase {
        return Room.databaseBuilder(
            context,
            TasksDataBase::class.java,
            "MyTasks.db"
        ).addCallback(
            object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Timber.d("OnCreate DB")
                    db.execSQL("INSERT INTO category (id,name,isDefault) VALUES(0,'My List',1)")
                    sharedPreferences.saveCurrentTasksList(0)
                }
            }
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}