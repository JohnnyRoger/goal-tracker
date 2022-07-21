package com.slicksoftcoder.goaltracker.feature.presentation.goals.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slicksoftcoder.goaltracker.feature.domain.util.GoalOrder
import com.slicksoftcoder.goaltracker.feature.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    goalOrder: GoalOrder = GoalOrder.Date(OrderType.Descending),
    onOrderChange: (GoalOrder) -> Unit

) {

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Objective",
                selected = goalOrder is GoalOrder.Objective,
                onSelect = { onOrderChange (GoalOrder.Objective(goalOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = goalOrder is GoalOrder.Date,
                onSelect = { onOrderChange (GoalOrder.Date(goalOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Color",
                selected = goalOrder is GoalOrder.Color,
                onSelect = { onOrderChange (GoalOrder.Color(goalOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier =Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = goalOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange (goalOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = goalOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange (goalOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}