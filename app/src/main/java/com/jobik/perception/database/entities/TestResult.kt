package com.jobik.perception.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "statistics",
    indices = [Index("test_name")],
)
data class TestResult(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "test_name") val testName: String,
    @ColumnInfo(name = "steps") val steps: String,
    @ColumnInfo(name = "result") val result: String,
    @ColumnInfo(name = "test_duration_seconds") val testDurationSeconds: Int,
    @ColumnInfo(name = "created_at") val createdAt: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "updated_at") val updatedAt: LocalDateTime = LocalDateTime.now(),
)