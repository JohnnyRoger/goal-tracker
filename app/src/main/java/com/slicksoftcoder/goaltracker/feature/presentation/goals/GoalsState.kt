package com.slicksoftcoder.goaltracker.feature.presentation.goals

import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.util.GoalOrder
import com.slicksoftcoder.goaltracker.feature.domain.util.OrderType

data class GoalsState(
    val goals: List<Goal> = emptyList(),
    val goalOrder: GoalOrder = GoalOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false

    )
