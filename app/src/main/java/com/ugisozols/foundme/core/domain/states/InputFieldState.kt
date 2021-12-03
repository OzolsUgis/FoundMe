package com.ugisozols.foundme.core.domain.states

import com.ugisozols.foundme.core.util.Error

data class InputFieldState(
    val text : String = "",
    val error : Error? = null
)
