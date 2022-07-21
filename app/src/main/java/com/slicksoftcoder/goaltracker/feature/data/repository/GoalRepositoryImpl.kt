package com.slicksoftcoder.goaltracker.feature.data.repository

import com.slicksoftcoder.goaltracker.feature.data.data_source.GoalDao
import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.repository.GoalRepository
import kotlinx.coroutines.flow.Flow

class GoalRepositoryImpl(
    private  val dao: GoalDao
) : GoalRepository {
    override fun getGoal(): Flow<List<Goal>> {
        return dao.getGoals()
    }

    override suspend fun getGoalById(id: Int): Goal? {
        return dao.getGoalById(id)
    }

    override suspend fun insertGoal(goal: Goal) {
        dao.insertGoal(goal)
    }

    override suspend fun deleteGoal(goal: Goal) {
        dao.deleteGoal(goal)
    }
}