package com.slicksoftcoder.goaltracker.feature.data.data_source

import androidx.room.*
import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {
    @Query("SELECT * FROM goal")
    fun getGoals(): Flow<List<Goal>>

    @Query("SELECT * FROM goal WHERE id = :id")
    suspend fun getGoalById(id: Int): Goal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: Goal)

    @Delete
    suspend fun deleteGoal(goal: Goal)
}