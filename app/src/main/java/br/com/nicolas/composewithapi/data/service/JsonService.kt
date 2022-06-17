package br.com.nicolas.composewithapi.data.service

import br.com.nicolas.composewithapi.models.PostsItem
import retrofit2.http.GET

interface JsonService {

    @GET("posts")
    suspend fun getPosts() : List<PostsItem>
}