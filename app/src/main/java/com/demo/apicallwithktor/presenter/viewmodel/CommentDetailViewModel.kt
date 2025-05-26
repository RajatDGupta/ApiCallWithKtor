package com.demo.apicallwithktor.presenter.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.apicallwithktor.core.common.Resource
import com.demo.apicallwithktor.core.common.UiState
import com.demo.apicallwithktor.domain.model.CommentDetail
import com.demo.apicallwithktor.domain.usecases.GetCommentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CommentDetailViewModel @Inject constructor(val commentDetailUseCase: GetCommentDetailUseCase) :
    ViewModel() {

    private val _comment = mutableStateOf(UiState<CommentDetail>())
    val comment: State<UiState<CommentDetail>> get() = _comment

    fun getCommentDetail(id: String) {
        commentDetailUseCase.invoke(id).onEach {
            when (it) {
                is Resource.Loading -> {
                    _comment.value = UiState(isLoading = true)
                }

                is Resource.Success -> {
                    _comment.value = UiState(data = it.data)
                }

                is Resource.Error -> {
                    _comment.value = UiState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}