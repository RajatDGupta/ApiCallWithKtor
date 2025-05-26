package com.demo.apicallwithktor.domain.usecases

import com.demo.apicallwithktor.core.common.Resource
import com.demo.apicallwithktor.domain.model.Comments
import com.demo.apicallwithktor.domain.repository.CommentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCommentListUseCase @Inject constructor(private val repositoryImpl: CommentsRepository) {
    operator fun invoke(): Flow<Resource<List<Comments>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = repositoryImpl.getCommentsList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}