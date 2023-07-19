package com.raghav.spacedawnv2.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raghav.spacedawnv2.domain.model.LaunchDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveReminder(launch: LaunchDetail)

    @Query("SELECT * FROM saved_launches")
    fun getReminders(): Flow<List<LaunchDetail>>

    @Query("DELETE FROM saved_launches WHERE id =:launchId")
    suspend fun deleteReminder(launchId: String)
}
