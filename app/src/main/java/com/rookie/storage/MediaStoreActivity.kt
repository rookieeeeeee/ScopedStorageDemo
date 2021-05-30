package com.rookie.storage

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.grandlynn.storage.ScopedStorage
import com.grandlynn.storage.filetype.mediastore.Base
import com.grandlynn.storage.filetype.mediastore.MediaFile

class MediaStoreActivity : AppCompatActivity() {

    lateinit var storage: ScopedStorage
    lateinit var file: Base
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mediastore)

        storage = ScopedStorage.Config()
            .legacyMode(ScopedStorage.LegacyMode.MODE_EXTERNAL_FILE)
            .preference("test")
            .prefix("piefix")
            .workdir("rookie")
            .buildStorage(this)
    }


    fun insert(view: View) {
        val file = MediaFile("test.txt", MediaFile.MediaType.MEDIA_TYPE_AUDIO)
        file.setRelativePath(Environment.DIRECTORY_DOWNLOADS + "/testDir1")
        file.setDisplayName("text2.txt")
        file.mimeType="json/application"
        file.setWidth(1000)
        file.setHeight(2000)
        val access = storage.access(file)
        if (access.createNewFile()) {
            access.outputStream.write("hello mediastore!!!".toByteArray())
            val readBytes = access.inputStream.readBytes()
            Log.d("test", String(readBytes))
        }


    }

    fun delete(view: View) {


    }

    fun query(view: View) {

    }

    fun update(view: View) {

    }
}