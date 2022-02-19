package com.lyvetech.bee.feature.data.repository

import com.lyvetech.bee.feature.data.local.WordInfoDAO
import com.lyvetech.bee.feature.data.remote.DictionaryApi

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDAO
) {
}