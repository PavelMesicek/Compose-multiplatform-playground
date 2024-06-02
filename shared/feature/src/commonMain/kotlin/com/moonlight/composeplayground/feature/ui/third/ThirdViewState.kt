package com.moonlight.composeplayground.feature.ui.third

import com.moonlight.composeplayground.resources.MR
import com.moonlight.composeplayground.util.arch.ViewState
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

data class ThirdViewState(
    val text: StringDesc = MR.strings.third_screen_text.desc(),
) : ViewState
