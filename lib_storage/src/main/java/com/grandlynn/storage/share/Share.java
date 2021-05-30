package com.grandlynn.storage.share;

import android.net.Uri;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rookie
 * on 2021-05-14 上午9:31
 */
public interface Share {

    void sharePlainText(String title,CharSequence text);

    void shareFile(String title, Uri uri, String mimeType);

    void shareMultiple(String title, List<Uri> uris, String mimeType);

}
