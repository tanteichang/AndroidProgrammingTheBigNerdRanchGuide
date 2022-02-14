package com.tantei.androidguide

import androidx.annotation.StringRes

enum class QuestionStatus {
    CORRECT, INCORRECT, UNREAD
}

data class Question(@StringRes val textResId: Int, val answer: Boolean) {
    var status: QuestionStatus = QuestionStatus.UNREAD
}