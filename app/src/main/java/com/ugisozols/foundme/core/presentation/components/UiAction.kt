package com.ugisozols.foundme.core.presentation.components

import com.ugisozols.foundme.core.util.TextMessage

sealed class UiAction{
    data class ShowSnackbar(val text: TextMessage) : UiAction()
}

