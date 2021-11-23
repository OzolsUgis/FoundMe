package com.ugisozols.foundme.core.util

import androidx.annotation.StringRes

sealed class TextMessage {
    data class SimpleString ( val value : String) : TextMessage()
    data class StringFromResources (@StringRes val id : Int) : TextMessage()
}
