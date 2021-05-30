package com.grandlynn.storage.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import java.io.File

/**
 *
 *  Created by rookie
 *  on 2021-05-14 上午11:05
 */
class ProtoDataStore {

    companion object {
        lateinit var dataStore: DataStore<Byte>
        fun create(file: File) {
//            dataStore= ProtoDataStore.create(file)
        }
    }

    val i=1;
}