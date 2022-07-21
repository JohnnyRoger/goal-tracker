package com.slicksoftcoder.goaltracker.feature.presentation.goals

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slicksoftcoder.goaltracker.feature.domain.model.Goal
import com.slicksoftcoder.goaltracker.feature.domain.use_case.GoalUseCases
import com.slicksoftcoder.goaltracker.feature.domain.util.GoalOrder
import com.slicksoftcoder.goaltracker.feature.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalsViewModel @Inject constructor(
    private val goalUseCases: GoalUseCases
) : ViewModel(){

    private val _state = mutableStateOf(GoalsState())
    val state: State<GoalsState> = _state

    private var recentlyDeletedGoal: Goal? = null

    private var getGoalsJob: Job? = null

    init {
        getGoals(GoalOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: GoalsEvent){
        when(event) {
            is GoalsEvent.Order -> {
                if(state.value.goalOrder::class == event.goalOrder::class &&
                        state.value.goalOrder.orderType == event.goalOrder.orderType
                ) {
                    return
                }
                getGoals(event.goalOrder)
            }
            is GoalsEvent.DeleteGoal -> {
                viewModelScope.launch {
                    goalUseCases.deleteGoal(event.goal)
                    recentlyDeletedGoal = event.goal
                }
            }
            is GoalsEvent.RestoreGoal -> {
                viewModelScope.launch {
                    goalUseCases.addGoal(recentlyDeletedGoal ?: return@launch)
                    recentlyDeletedGoal = null
                }
            }
            is GoalsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getGoals(goalOrder: GoalOrder){
        getGoalsJob?.cancel()
        getGoalsJob = goalUseCases.getGoals(goalOrder)
            .onEach { goals ->
                _state.value = state.value.copy(
                    goals = goals,
                    goalOrder = goalOrder
                )
            }
            .launchIn(viewModelScope)
    }

}