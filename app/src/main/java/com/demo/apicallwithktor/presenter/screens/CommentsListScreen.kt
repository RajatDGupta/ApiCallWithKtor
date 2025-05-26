package com.demo.apicallwithktor.presenter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.apicallwithktor.presenter.screens.component.CommentListItem
import com.demo.apicallwithktor.presenter.screens.component.ErrorView
import com.demo.apicallwithktor.presenter.screens.component.ProgressBar
import com.demo.apicallwithktor.presenter.viewmodel.CommentsListViewModel

@Composable
fun CommentsListScreen(paddingValues: PaddingValues, onItemClick: (String) -> Unit) {

    val viewModel: CommentsListViewModel = hiltViewModel()

    var result = viewModel.commentList.value

    if (result.isLoading) {
        ProgressBar()
    }

    result.data?.let {
        Column(
            Modifier.windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(it) {
                    CommentListItem(it) {
                        onItemClick(it)
                    }
                }
            }
        }
    }

    if (result.error.isNotEmpty()) {
        ErrorView(result.error)
    }

}