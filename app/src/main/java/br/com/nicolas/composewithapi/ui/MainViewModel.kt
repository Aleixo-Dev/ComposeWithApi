package br.com.nicolas.composewithapi.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nicolas.composewithapi.data.repository.ComposeRepository
import br.com.nicolas.composewithapi.models.PostsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ComposeRepository) : ViewModel() {

    private val _posts = mutableStateOf<List<PostsItem>>(listOf())
    val post: State<List<PostsItem>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() = viewModelScope.launch {
        _posts.value = repository.fetchPosts()
    }
}