package com.slicksoftcoder.goaltracker.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slicksoftcoder.goaltracker.feature.domain.model.Goal

@Database(
    entities = [Goal::class],
    version = 1
)
abstract class GoalDatabase: RoomDatabase() {
    abstract val goalDao: GoalDao

    companion object{
        const val DATABASE_NAME = "goals_db"
    }
}