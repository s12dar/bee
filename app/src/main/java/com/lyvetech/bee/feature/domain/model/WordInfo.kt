package com.lyvetech.bee.feature.domain.model

import com.lyvetech.bee.feature.data.remote.dto.MeaningDto

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
