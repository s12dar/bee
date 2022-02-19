package com.lyvetech.bee.feature.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lyvetech.bee.feature.data.local.Converters
import com.lyvetech.bee.feature.data.local.WordInfoDAO

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {
    abstract val dao: WordInfoDAO
}