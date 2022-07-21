package com.slicksoftcoder.goaltracker.feature.domain.use_case

data class GoalUseCases(
    val getGoals: GetGoals,
    val deleteGoal: DeleteGoal,
    val addGoal: AddGoal
)
