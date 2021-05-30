package com.grandlynn.storage.provider;

import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;

/**
 * Created by rookie
 * on 2021-05-14 下午3:09
 */
public interface Provider {

    void provideFile(File file);

    @RequiresApi(api = Build.VERSION_CODES.O)
    void provideFile(Uri uri);
}
