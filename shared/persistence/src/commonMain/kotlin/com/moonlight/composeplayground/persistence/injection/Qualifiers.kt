package com.moonlight.composeplayground.persistence.injection

import org.koin.core.qualifier.named

internal object Qualifiers {

    val PersistenceJson = named("PersistenceJson")
    val DataStorePath = named("DataStoreFilePath")
}
