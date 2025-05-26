package com.demo.apicallwithktor.data.repository

import com.demo.apicallwithktor.core.common.toCommentDetail
import com.demo.apicallwithktor.core.common.toCommentsList
import com.demo.apicallwithktor.data.model.CommentsDTO
import com.demo.apicallwithktor.data.network.CommentsApiService
import com.demo.apicallwithktor.domain.model.CommentDetail
import com.demo.apicallwithktor.domain.model.Comments
import com.demo.apicallwithktor.domain.repository.CommentsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepositoryImpl @Inject constructor(val apiService: CommentsApiService) :
    CommentsRepository {

    private var commentList = emptyList<CommentsDTO>()

    override suspend fun getCommentsList(): List<Comments> {
        return apiService.getCommentListAPI().also {
            commentList = it
        }.map { it.toCommentsList() }
    }

    override suspend fun getCommentDetail(id: String): CommentDetail {
        return commentList.single { (it.id.toString()) == id }.toCommentDetail()
    }

}