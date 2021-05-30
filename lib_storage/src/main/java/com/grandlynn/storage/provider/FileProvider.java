package com.grandlynn.storage.provider;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;
import androidx.documentfile.provider.DocumentFile;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.util.IntentUtil;

import java.io.File;

/**
 * Created by rookie
 * on 2021-05-14 下午3:37
 */
public class FileProvider implements Provider {
    ScopedStorage mScopedStorage;

    public FileProvider(ScopedStorage scopedStorage) {
        mScopedStorage = scopedStorage;
    }

    @Override
    public void provideFile(File file) {
        Context context = mScopedStorage.getContext();
        Intent intent = IntentUtil.openFile(context, file.getAbsolutePath());
        context.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void provideFile(Uri uri) {
        Context context = mScopedStorage.getContext();
        boolean documentUri = DocumentFile.isDocumentUri(context, uri);
        DocumentFile documentFile;

        //不知道有没有影响
        if (documentUri) {
            documentFile = DocumentFile.fromSingleUri(context, uri);
        } else {
            Uri documenturi = MediaStore.getDocumentUri(context,uri);
            documentFile = DocumentFile.fromSingleUri(context, documenturi);
        }
        Intent intent = IntentUtil.getDocumentIntent(documentFile);
        context.startActivity(intent);
    }

}
