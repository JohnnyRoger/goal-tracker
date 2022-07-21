package com.slicksoftcoder.goaltracker.feature.domain.util

sealed class GoalOrder(val orderType: OrderType){
    class Objective(orderType: OrderType): GoalOrder(orderType)
    class Date(orderType: OrderType): GoalOrder(orderType)
    class Color(orderType: OrderType): GoalOrder(orderType)

    fun copy(orderType: OrderType): GoalOrder {
        return when(this) {
            is Objective -> Objective(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}
