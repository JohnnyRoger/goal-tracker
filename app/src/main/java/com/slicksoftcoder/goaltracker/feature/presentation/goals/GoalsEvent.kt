package com.slicksoftcoder.goaltracker.feature.presentation.goals

import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.util.GoalOrder

sealed class GoalsEvent {
    data class Order(val goalOrder: GoalOrder): GoalsEvent()
    data class DeleteGoal(val goal: Goal): GoalsEvent()
    object RestoreGoal: GoalsEvent()
    object ToggleOrderSection: GoalsEvent()
}
