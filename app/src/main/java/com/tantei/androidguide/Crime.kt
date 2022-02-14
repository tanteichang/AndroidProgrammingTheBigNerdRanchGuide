package com.tantei.androidguide

import androidx.room.*
import java.util.*

@Entity
data class Crime(
    @PrimaryKey
    var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false
)