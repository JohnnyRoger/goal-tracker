package com.slicksoftcoder.goaltracker.di

import android.app.Application
import androidx.room.Room
import com.slicksoftcoder.goaltracker.feature.data.data_source.GoalDatabase
import com.slicksoftcoder.goaltracker.feature.data.repository.GoalRepositoryImpl
import com.slicksoftcoder.goaltracker.feature.domain.repository.GoalRepository
import com.slicksoftcoder.goaltracker.feature.domain.use_case.AddGoal
import com.slicksoftcoder.goaltracker.feature.domain.use_case.DeleteGoal
import com.slicksoftcoder.goaltracker.feature.domain.use_case.GetGoals
import com.slicksoftcoder.goaltracker.feature.domain.use_case.GoalUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGoalDatabase(app: Application): GoalDatabase{
        return Room.databaseBuilder(
            app,
            GoalDatabase::class.java,
        GoalDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideGoalRepository(db: GoalDatabase): GoalRepository {
        return GoalRepositoryImpl(db.goalDao)
    }

    @Provides
    @Singleton
    fun provideGoalUseCases(repository: GoalRepository) : GoalUseCases {
        return GoalUseCases(
            getGoals = GetGoals(repository),
            deleteGoal = DeleteGoal(repository),
            addGoal = AddGoal(repository)
        )
    }
}