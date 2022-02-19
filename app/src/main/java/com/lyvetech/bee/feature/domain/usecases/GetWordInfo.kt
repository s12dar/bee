package com.lyvetech.bee.feature.domain.usecases

import com.lyvetech.bee.core.util.Resource
import com.lyvetech.bee.feature.domain.model.WordInfo
import com.lyvetech.bee.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}