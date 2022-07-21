package com.slicksoftcoder.goaltracker.feature.domain.use_case

import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.repository.GoalRepository
import com.slicksoftcoder.goaltracker.feature.domain.util.GoalOrder
import com.slicksoftcoder.goaltracker.feature.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetGoals(
    private val repository: GoalRepository
) {

    operator  fun invoke(goalOrder: GoalOrder = GoalOrder.Date(OrderType.Descending)): Flow<List<Goal>>{
return repository.getGoal().map { goals ->
    when(goalOrder.orderType){
        is OrderType.Ascending -> {
            when(goalOrder){
                is GoalOrder.Objective -> goals.sortedBy { it.objective.lowercase() }
                is GoalOrder.Date -> goals.sortedBy { it.timestamp }
                is GoalOrder.Color -> goals.sortedBy { it.color}
            }
        }
        is OrderType.Descending -> {
            when(goalOrder){
                is GoalOrder.Objective -> goals.sortedByDescending { it.objective.lowercase() }
                is GoalOrder.Date -> goals.sortedBy { it.timestamp }
                is GoalOrder.Color -> goals.sortedBy { it.color}
            }
        }
    }
}
    }
}