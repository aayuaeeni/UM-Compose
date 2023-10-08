
package com.raju.um_compose.presentation.ui.screen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raju.um_compose.presentation.viewmodel.JokeViewModel

@Composable
fun MainScreen(viewModel: JokeViewModel= hiltViewModel() ) {
    val jokes by viewModel.jokesLD.observeAsState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        jokes?.jokes?.let {
            itemsIndexed(items = it,
                itemContent = { _, joke ->
                    val visible by remember { mutableStateOf(true) }
                    AnimatedVisibility(
                        visible = visible,
                        enter = slideInVertically(
                            initialOffsetY = { -40 }
                        ) + expandVertically(
                            expandFrom = Alignment.Top
                        ) + scaleIn(
                            transformOrigin = TransformOrigin(0.5f, 0f)
                        ) + fadeIn(initialAlpha = 0.3f),
                        exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)
                    ) {
                        Card(
                            shape = RoundedCornerShape(4.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(16.dp, 4.dp, 16.dp, 4.dp)
                        ) {
                            Text(
                                joke.joke, style = TextStyle(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                })
        }
    }
}