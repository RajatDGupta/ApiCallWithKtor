package com.demo.apicallwithktor.core.common

import com.demo.apicallwithktor.data.model.CommentsDTO
import com.demo.apicallwithktor.domain.model.CommentDetail
import com.demo.apicallwithktor.domain.model.Comments

fun CommentsDTO.toCommentsList(): Comments {
    return Comments(id = id, name = name, body = body)
}

fun CommentsDTO.toCommentDetail(): CommentDetail {
    return CommentDetail(
        id = id,
        name = name,
        email = email,
        body = body
    )
}