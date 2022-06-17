package br.com.nicolas.composewithapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.nicolas.composewithapi.models.PostsItem
import br.com.nicolas.composewithapi.ui.MainViewModel
import br.com.nicolas.composewithapi.ui.theme.ComposeWithApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithApiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()

    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 8.dp),
        content = {
            items(items = viewModel.post.value) { post ->
                PostItem(postsItem = post)
            }
        }
    )
}

@Composable
fun PostItem(postsItem: PostsItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ) {
        Text(
            text = postsItem.title,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = postsItem.body,
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider()
    }
}
