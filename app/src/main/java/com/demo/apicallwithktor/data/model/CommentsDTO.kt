package com.demo.apicallwithktor.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CommentsDTO(
    val postId: String,
    val id: String,
    val name: String,
    val email: String,
    val body: String
)
