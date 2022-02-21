package com.lyvetech.bee.feature.presentation

import com.lyvetech.bee.feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)