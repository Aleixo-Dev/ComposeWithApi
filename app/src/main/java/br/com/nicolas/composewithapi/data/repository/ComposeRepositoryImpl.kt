package br.com.nicolas.composewithapi.data.repository

import br.com.nicolas.composewithapi.data.service.JsonService
import javax.inject.Inject

class ComposeRepositoryImpl @Inject constructor(
    private val service: JsonService
) : ComposeRepository {

    override suspend fun fetchPosts() = service.getPosts()
}