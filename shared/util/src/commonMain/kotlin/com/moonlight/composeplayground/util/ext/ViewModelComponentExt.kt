package com.moonlight.composeplayground.util.ext

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.moonlight.composeplayground.util.arch.SharedViewModel
import com.moonlight.composeplayground.util.arch.ViewModelComponent
import org.koin.core.component.get
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.mp.KoinPlatformTools

/**
 * Returns previously stored, or creates a new [InstanceKeeper.Instance] of [SharedViewModel]
 * inside [ViewModelComponent].
 *
 * The injection happens only once, when [ViewModelComponent] is created thanks to the lazy injector.
 * This makes sure that the same ViewModel is used across configuration changes.
 */
inline fun <reified VM : SharedViewModel<*, *>> ViewModelComponent<VM>.viewModel(
    qualifier: Qualifier? = null,
    mode: LazyThreadSafetyMode = KoinPlatformTools.defaultLazyMode(),
    noinline parameters: ParametersDefinition? = null,
): Lazy<VM> = lazy(mode) { instanceKeeper.getOrCreate { get(qualifier, parameters) } }
