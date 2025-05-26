package com.demo.apicallwithktor.data.network

import com.demo.apicallwithktor.data.model.CommentsDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class CommentsApiService @Inject constructor(val httpClient: HttpClient) {

    suspend fun getCommentListAPI(): List<CommentsDTO> {
        return httpClient.get("https://jsonplaceholder.typicode.com/comments")
            .body<List<CommentsDTO>>()
    }

}