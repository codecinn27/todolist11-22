package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskItemDao{
    @Query("SELECT * FROM task_item_table ORDER BY id ASC")
    fun allTaskItem(): Flow<List<ClassItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItem : ClassItem)

    @Update
    suspend fun updateTaskItem(taskItem : ClassItem)

    @Delete
    suspend fun deleteTaskItem(taskItem : ClassItem)
}