package com.demo.apicallwithktor.domain.usecases

import com.demo.apicallwithktor.core.common.Resource
import com.demo.apicallwithktor.domain.model.CommentDetail
import com.demo.apicallwithktor.domain.repository.CommentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCommentDetailUseCase @Inject constructor(private val repository: CommentsRepository) {

    operator fun invoke(id: String): Flow<Resource<CommentDetail>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = repository.getCommentDetail(id)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}