package com.slicksoftcoder.goaltracker.feature.domain.use_case

import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.model.InvalidGoalException
import com.slicksoftcoder.goaltracker.feature.domain.repository.GoalRepository

class AddGoal(
    private val repository: GoalRepository
) {

    @Throws(InvalidGoalException::class)
    suspend operator fun invoke(goal: Goal){
        if(goal.objective.isBlank()){
            throw InvalidGoalException("The objective of the goal can't be empty.")
        }
        repository.insertGoal(goal)
    }
}