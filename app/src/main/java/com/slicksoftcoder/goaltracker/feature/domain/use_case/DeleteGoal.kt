package com.slicksoftcoder.goaltracker.feature.domain.use_case

import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.repository.GoalRepository

class DeleteGoal(
    private val repository: GoalRepository
) {
    suspend operator fun invoke(goal: Goal){
        repository.deleteGoal(goal)
    }
}