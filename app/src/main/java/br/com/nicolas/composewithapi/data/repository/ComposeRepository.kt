package br.com.nicolas.composewithapi.data.repository

import br.com.nicolas.composewithapi.models.PostsItem

interface ComposeRepository {

    suspend fun fetchPosts(): List<PostsItem>

}