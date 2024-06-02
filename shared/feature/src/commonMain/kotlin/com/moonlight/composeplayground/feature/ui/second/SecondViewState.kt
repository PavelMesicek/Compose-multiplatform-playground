package com.moonlight.composeplayground.feature.ui.second

import com.moonlight.composeplayground.resources.MR
import com.moonlight.composeplayground.util.arch.ViewState
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

data class SecondViewState(
    val text: StringDesc = MR.strings.second_screen_text.desc(),
) : ViewState
