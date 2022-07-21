package com.slicksoftcoder.goaltracker.feature.presentation.goals

import androidx.lifecycle.ViewModel
import com.slicksoftcoder.goaltracker.feature.domain.use_case.GoalUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoalsViewModel @Inject constructor(
    private val goalUseCases: GoalUseCases
) : ViewModel(){



}