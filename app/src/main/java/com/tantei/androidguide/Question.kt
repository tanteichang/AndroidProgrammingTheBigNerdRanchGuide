package com.tantei.androidguide

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean)