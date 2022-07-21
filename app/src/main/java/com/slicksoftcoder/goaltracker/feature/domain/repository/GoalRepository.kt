package com.slicksoftcoder.goaltracker.feature.domain.repository

import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import kotlinx.coroutines.flow.Flow

interface GoalRepository {

    fun getGoal(): Flow<List<Goal>>
    suspend fun  getGoalById(id: Int): Goal?
    suspend fun insertGoal(goal: Goal)
    suspend fun deleteGoal(goal: Goal)
}