package com.slicksoftcoder.goaltracker.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slicksoftcoder.goaltracker.ui.theme.*

@Entity
data class Goal(
    @PrimaryKey val id: Int? = null,
    val objective: String,
    val timeframe: Long,
    val status: Int,
    val timestamp: Long,
    val color: Int
) {
    companion object{
        val goalColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
