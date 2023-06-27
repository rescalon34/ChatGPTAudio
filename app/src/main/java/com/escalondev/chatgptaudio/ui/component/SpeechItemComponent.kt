package com.escalondev.chatgptaudio.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.escalondev.chatgptaudio.R
import com.escalondev.chatgptaudio.ui.util.ItemType
import com.escalondev.chatgptaudio.ui.util.getAsyncImageModel
import com.escalondev.domain.model.SpeechItem

@Composable
fun SpeechItemComponent(
    modifier: Modifier = Modifier,
    speechItem: SpeechItem = SpeechItem(),
    onIconClick: () -> Unit = {},
) {

    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(CornerSize(12.dp)),
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column {
            AsyncImage(
                model = getAsyncImageModel(
                    data = speechItem.image,
                    context = LocalContext.current
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(speechItem.title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            SpeechItemSummary(
                speechItem,
                isExpanded = isExpanded,
                onIconClick = onIconClick,
                onExpandableCardClick = {
                    isExpanded = !isExpanded
                },
            )
        }
    }
}

@Preview
@Composable
fun SpeechItemComponentPreview() {
    SpeechItemComponent(
        modifier = Modifier.fillMaxWidth(),
        speechItem = SpeechItem(
            idType = ItemType.Transcription.itemType,
            title = R.string.transcription_title,
            subTitle = R.string.transcription_subtitle,
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWGcbqlYbUuPG5Mk4ecW44O6s94HfbIJ2nBQ&usqp=CAU",
        )
    )
}
