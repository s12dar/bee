package com.lyvetech.bee.feature.data.remote

import com.lyvetech.bee.feature.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInformation(
        @Path("word") word: String
    ): List<WordInfoDto>
}