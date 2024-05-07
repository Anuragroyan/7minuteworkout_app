package com.example.a7minutesworkoutapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    fun insert(historyEntity: HistoryEntity)
//    @Query("SELECT * FROM `history_table`")
//    fun fetchAllDates(): Flow<List<HistoryEntity>>
}