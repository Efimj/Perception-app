package com.jobik.perception.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jobik.perception.database.entities.TestResult
import kotlinx.coroutines.flow.Flow

@Dao
interface TestResultDao {
    @Query("SELECT * FROM statistics")
    fun getAll(): Flow<List<TestResult>>

    @Query("SELECT * FROM statistics WHERE test_name = :testId")
    fun findByTestId(testId: Long): Flow<List<TestResult>>

    @Insert
    suspend fun insertAll(vararg testResults: TestResult)
}