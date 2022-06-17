package br.com.nicolas.composewithapi.di

import br.com.nicolas.composewithapi.data.repository.ComposeRepository
import br.com.nicolas.composewithapi.data.repository.ComposeRepositoryImpl
import br.com.nicolas.composewithapi.data.service.JsonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ComposeModule {

    @Provides
    @Singleton
    fun provideApi(): JsonService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(JsonService::class.java)
    }

    @Provides
    @Singleton
    fun provideComposeRepository(service: JsonService): ComposeRepository {
        return ComposeRepositoryImpl(service)
    }
}