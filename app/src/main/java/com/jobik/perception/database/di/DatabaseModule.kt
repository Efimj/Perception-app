package com.jobik.perception.database.di

import android.app.Application
import androidx.room.Room
import com.jobik.perception.database.PerceptionDB
import com.jobik.perception.database.daos.TestResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providePerceptionDB(app: Application): PerceptionDB {
        return Room.databaseBuilder(
            context = app,
            klass = PerceptionDB::class.java,
            name = "perception.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePerceptionDao(perceptionDB: PerceptionDB): TestResultDao {
        return perceptionDB.testResultDao()
    }
}