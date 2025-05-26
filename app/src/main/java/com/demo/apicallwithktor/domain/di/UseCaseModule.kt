package com.demo.apicallwithktor.domain.di

import com.demo.apicallwithktor.data.repository.CommentRepositoryImpl
import com.demo.apicallwithktor.domain.usecases.GetCommentDetailUseCase
import com.demo.apicallwithktor.domain.usecases.GetCommentListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun commentListUseCaseProvider(repositoryImpl: CommentRepositoryImpl): GetCommentListUseCase {
        return GetCommentListUseCase(repositoryImpl)
    }

    @Provides
    @Singleton
    fun productDetailUseCaseProvider(repositoryImpl: CommentRepositoryImpl): GetCommentDetailUseCase {
        return GetCommentDetailUseCase(repositoryImpl)
    }

}