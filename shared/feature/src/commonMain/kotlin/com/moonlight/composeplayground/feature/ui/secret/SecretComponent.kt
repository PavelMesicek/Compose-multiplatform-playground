package com.moonlight.composeplayground.feature.ui.secret

import com.moonlight.composeplayground.feature.navigation.home.HomeStackNavigator
import com.moonlight.composeplayground.resources.MR
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class SecretComponent(arg: String?) : SecretScreen, KoinComponent {

    private val homeNavigator: HomeStackNavigator by inject()

    override val title: StringDesc = MR.strings.secret_screen_title.desc()
    override val text: StringDesc = StringDesc.ResourceFormatted(MR.strings.secret_screen_text, arg.toString())

    override fun goBack() {
        homeNavigator.pop()
    }
}
