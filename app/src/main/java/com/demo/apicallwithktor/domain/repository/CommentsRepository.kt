package com.demo.apicallwithktor.domain.repository

import com.demo.apicallwithktor.domain.model.CommentDetail
import com.demo.apicallwithktor.domain.model.Comments

interface CommentsRepository {

    suspend fun getCommentsList(): List<Comments>

    suspend fun getCommentDetail(id: String): CommentDetail

}