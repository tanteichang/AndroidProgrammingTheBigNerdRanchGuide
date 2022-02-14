package com.tantei.androidguide

import java.util.*

data class Crime(
    var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false
)