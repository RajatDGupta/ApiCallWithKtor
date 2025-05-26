package com.demo.apicallwithktor.domain.model

data class CommentDetail(
    val id: String,
    val name: String,
    val email: String,
    val body: String
)