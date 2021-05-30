package com.grandlynn.storage.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import java.io.File

/**
 *
 *  Created by rookie
 *  on 2021-05-14 上午10:45
 */
class PreferenceDataStore {

    companion object {
        lateinit var dataStore: DataStore<Preferences>
        fun create(file: File) {
            dataStore=PreferenceDataStoreFactory.create {
                file
            }
        }
    }
    val i=1;
}
