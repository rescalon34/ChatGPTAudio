package com.escalondev.domain.di

import com.escalondev.domain.interactor.home.CreateTranscriptionUseCase
import com.escalondev.domain.interactor.home.CreateTranscriptionUseCaseImpl
import com.escalondev.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractionModule {

    @Provides
    fun createTranscriptionUseCase(homeRepository: HomeRepository): CreateTranscriptionUseCase =
        CreateTranscriptionUseCaseImpl(homeRepository)
}
