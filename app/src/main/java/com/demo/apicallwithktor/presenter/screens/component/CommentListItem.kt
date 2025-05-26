package com.demo.apicallwithktor.presenter.screens.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.apicallwithktor.domain.model.Comments

@Composable
fun CommentListItem(comments: Comments, onItemClick: (String) -> Unit) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {
            onItemClick(comments.id)
        }) {
        Text(
            text = comments.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = comments.body,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }

}