package com.moonlight.composeplayground.feature.ui.first

import com.moonlight.composeplayground.util.arch.ViewState
import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.StringDesc

data class FirstViewState(
    val text: StringDesc = StringDesc.Raw("Loading..."),
) : ViewState
