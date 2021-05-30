package com.grandlynn.storage.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rookie
 * on 2021-05-14 上午9:31
 */
public class SimpleShare implements Share {
    ScopedStorage mScopedStorage;

    public SimpleShare(ScopedStorage scopedStorage) {
        mScopedStorage = scopedStorage;
    }

    @Override
    public void sharePlainText(String title, CharSequence text) {
        Context context = mScopedStorage.getContext();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, title);
        context.startActivity(shareIntent);
    }

    @Override
    public void shareFile(String tile, Uri uri, String mime) {
        Context context = mScopedStorage.getContext();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        sendIntent.setType(mime);
        Intent shareIntent = Intent.createChooser(sendIntent, tile);
        context.startActivity(shareIntent);
    }

    @Override
    public void shareMultiple(String title, List<Uri> uris, String mimeType) {
        Context context = mScopedStorage.getContext();
        ArrayList<Uri> arrayList = new ArrayList<>(uris);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, arrayList);
        sendIntent.setType(mimeType);
        Intent shareIntent = Intent.createChooser(sendIntent, title);
        context.startActivity(shareIntent);
    }


}
