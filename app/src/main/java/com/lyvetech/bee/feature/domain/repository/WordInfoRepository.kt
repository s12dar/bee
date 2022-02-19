package com.lyvetech.bee.feature.domain.repository

import com.lyvetech.bee.core.util.Resource
import com.lyvetech.bee.feature.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow


interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}