package com.escalondev.chatgptaudio.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.escalondev.chatgptaudio.R
import com.escalondev.domain.model.SpeechItem

@Composable
fun SpeechItemSummary(
    speechItem: SpeechItem,
    isExpanded: Boolean = false,
    onIconClick: () -> Unit = {},
    onExpandableCardClick: () -> Unit = {}
) {

    Column(Modifier.clickable {
        onExpandableCardClick.invoke()
    }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                modifier = Modifier.padding(all = 16.dp),
                text = stringResource(speechItem.subTitle),
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onIconClick) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = speechItem.icon),
                    contentDescription = null
                )
            }
        }
        if (isExpanded) {
            Text(
                modifier = Modifier
                    .padding(all = 16.dp),
                style = MaterialTheme.typography.bodyLarge,
                text = speechItem.text
            )
        }
    }
}

@Preview
@Composable
fun SpeechItemPreview() {
    SpeechItemSummary(
        SpeechItem(
            subTitle = R.string.transcription_subtitle,
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        )
    )
}
