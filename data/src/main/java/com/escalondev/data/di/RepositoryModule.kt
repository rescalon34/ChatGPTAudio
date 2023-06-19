package com.escalondev.data.di

import com.escalondev.data.networking.NetworkApi
import com.escalondev.data.repository.HomeRepositoryImpl
import com.escalondev.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        networkApi: NetworkApi
    ): HomeRepository = HomeRepositoryImpl(networkApi)
}
