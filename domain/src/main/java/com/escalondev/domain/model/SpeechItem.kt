package com.escalondev.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class SpeechItem(
    val idType: String = "",
    @StringRes val title: Int = 0,
    @StringRes val subTitle: Int = 0,
    var text: String = "",
    val image: String = "",
    @DrawableRes val icon: Int = 0,
)
