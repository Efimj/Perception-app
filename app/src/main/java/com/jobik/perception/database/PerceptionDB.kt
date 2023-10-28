package com.jobik.perception.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jobik.perception.database.converters.LocalDateTimeConverter
import com.jobik.perception.database.dao.TestResultDao
import com.jobik.perception.database.entities.TestResult

@Database(
    entities = [
        TestResult::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class PerceptionDB : RoomDatabase() {
    abstract fun testResultDao(): TestResultDao

    companion object{
        fun createDB(context: Context): PerceptionDB{
            return  Room.databaseBuilder(
                context = context,
                klass = PerceptionDB::class.java,
                name = "perception.db"
            ).build()
        }
    }

}