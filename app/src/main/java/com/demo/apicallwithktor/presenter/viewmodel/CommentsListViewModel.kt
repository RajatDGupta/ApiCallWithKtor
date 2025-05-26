package com.demo.apicallwithktor.presenter.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.apicallwithktor.core.common.Resource
import com.demo.apicallwithktor.core.common.UiState
import com.demo.apicallwithktor.domain.model.Comments
import com.demo.apicallwithktor.domain.usecases.GetCommentListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CommentsListViewModel @Inject constructor(
    commentListUseCase: GetCommentListUseCase,
) : ViewModel() {

    private val _commentList = mutableStateOf(UiState<List<Comments>>())
    val commentList: State<UiState<List<Comments>>> get() = _commentList

    init {
        commentListUseCase.invoke().onEach {
            when (it) {
                is Resource.Loading -> {
                    _commentList.value = UiState(isLoading = true)
                }

                is Resource.Success -> {
                    _commentList.value = UiState(data = it.data)
                }

                is Resource.Error -> {
                    _commentList.value = UiState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}