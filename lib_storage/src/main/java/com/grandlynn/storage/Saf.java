package com.grandlynn.storage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;

/**
 * 封装了saf的相关操作
 * 需要在onActivityResult中手动调用 ActivityResultContracts.parseResult()
 * <p>
 * 当然你也可以让你的Activity继承androidx.AppCompatActivity并调用registerForActivityResult注册回调获取结果
 * <p>
 * Created by rookie
 * on 2021-05-13 下午2:40
 */
public class Saf {

    public static final int REQ_SAVE_FILE = 1111;
    public static final int REQ_OPEN_FILE = 1112;
    public static final int REQ_OPEN_DIR  = 1113;

    public static ActivityResultContracts.CreateDocument saveFile(Activity activity, String tile) {
        ActivityResultContracts.CreateDocument createDocument = new ActivityResultContracts.CreateDocument();
        Intent intent = createDocument.createIntent(activity, tile);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(intent, REQ_SAVE_FILE);
        return createDocument;
    }

    /**
     * 可以指定初始位置
     *
     * @param activity
     * @param tile
     * @param initialLocation
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ActivityResultContracts.CreateDocument saveFile(Activity activity, String tile, Uri initialLocation) {
        ActivityResultContracts.CreateDocument createDocument = new ActivityResultContracts.CreateDocument();
        Intent intent = createDocument.createIntent(activity, tile);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        if (initialLocation != null)
            intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, initialLocation);
        activity.startActivityForResult(intent, REQ_SAVE_FILE);
        return createDocument;
    }

    public static ActivityResultContracts.OpenDocument openFile(Activity activity, String[] mimeTypes) {
        ActivityResultContracts.OpenDocument openDocument = new ActivityResultContracts.OpenDocument();
        Intent intent = openDocument.createIntent(activity, mimeTypes);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(intent, REQ_OPEN_FILE);
        return openDocument;
    }

    /**
     * 可以指定初始位置
     *
     * @param activity
     * @param initialLocation
     * @param mimeTypes
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ActivityResultContracts.OpenDocument openFile(Activity activity, Uri initialLocation, String[] mimeTypes) {
        ActivityResultContracts.OpenDocument openDocument = new ActivityResultContracts.OpenDocument();
        Intent intent = openDocument.createIntent(activity, mimeTypes);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        if (initialLocation != null)
            intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, initialLocation);
        activity.startActivityForResult(intent, REQ_OPEN_FILE);
        return openDocument;
    }

    /**
     * 打开目录
     *
     * @param activity
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static ActivityResultContracts.OpenDocumentTree openDir(Activity activity) {
        ActivityResultContracts.OpenDocumentTree openDocument = new ActivityResultContracts.OpenDocumentTree();
        Intent intent = openDocument.createIntent(activity, null);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        activity.startActivityForResult(intent, REQ_OPEN_DIR);
        return openDocument;
    }

    /**
     * 可指定初始位置
     *
     * @param activity
     * @param initialLocation
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.O)
    public static ActivityResultContracts.OpenDocumentTree openDir(Activity activity, Uri initialLocation) {
        ActivityResultContracts.OpenDocumentTree openDocument = new ActivityResultContracts.OpenDocumentTree();
        Intent intent = openDocument.createIntent(activity, initialLocation);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        activity.startActivityForResult(intent, REQ_OPEN_DIR);
        return openDocument;
    }


    public static void takeForeverPermissions(Context context, Uri uri) {
        final int takeFlags = (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        // Check for the freshest data.
        context.getContentResolver().takePersistableUriPermission(uri, takeFlags);
    }

}
