package com.jobik.perception.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jobik.perception.database.converters.LocalDateTimeConverter
import com.jobik.perception.database.daos.TestResultDao
import com.jobik.perception.database.entities.TestResult

@Database(
    entities = [
        TestResult::class,
    ],
    version = 1,
    // remove on prod
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class PerceptionDB : RoomDatabase() {
    abstract fun testResultDao(): TestResultDao
}