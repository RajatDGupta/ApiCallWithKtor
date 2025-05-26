package com.demo.apicallwithktor.presenter.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.apicallwithktor.presenter.screens.component.ErrorView
import com.demo.apicallwithktor.presenter.screens.component.ProgressBar
import com.demo.apicallwithktor.presenter.viewmodel.CommentDetailViewModel

@Composable
fun CommentDetailScreen(id: String) {

    val viewModel: CommentDetailViewModel = hiltViewModel()

    var result = viewModel.comment.value

    LaunchedEffect(Unit) {
        viewModel.getCommentDetail(id)
    }

    if (result.isLoading) {
        ProgressBar()
    }


    result.data?.let {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            Text(
                text = it.id,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = it.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = it.email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = it.body,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }


    if (result.error.isNotEmpty()) {
        ErrorView(result.error)
    }
}