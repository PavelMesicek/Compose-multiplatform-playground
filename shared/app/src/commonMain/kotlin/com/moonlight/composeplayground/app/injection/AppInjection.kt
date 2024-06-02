package com.moonlight.composeplayground.app.injection

import com.moonlight.composeplayground.feature.injection.FeatureModule
import com.moonlight.composeplayground.network.graphql.injection.NetworkGraphqlModule
import com.moonlight.composeplayground.network.rest.injection.NetworkRestModule
import com.moonlight.composeplayground.persistence.injection.persistenceModule
import com.moonlight.composeplayground.platform.binding.PlatformBindings
import com.moonlight.composeplayground.platform.injection.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

/**
 * Injection entry-point.
 * This object initialises dependency injection in application.
 */
internal object AppInjection {

    fun initializeInjection(
        platformBindings: PlatformBindings,
        appDeclaration: KoinAppDeclaration?,
    ) {
        startKoin {
            if (appDeclaration != null) {
                appDeclaration()
            }

            modules(
                platformModule(platformBindings = platformBindings),
                FeatureModule().module,
                NetworkGraphqlModule().module,
                NetworkRestModule().module,
                persistenceModule(),
            )
        }
    }
}
