package com.slicksoftcoder.goaltracker.feature.domain.util

sealed class GoalOrder(val orderType: OrderType){
    class Objective(orderType: OrderType): GoalOrder(orderType)
    class Date(orderType: OrderType): GoalOrder(orderType)
    class Color(orderType: OrderType): GoalOrder(orderType)
}
