package com.grandlynn.storage.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import com.grandlynn.storage.ScopedStorage;

import java.io.File;

/**
 * Created by rookie
 * on 2021-05-14 下午3:16
 */
public class MyFileProvider extends FileProvider {


    public static Uri getUriForFile(@NonNull ScopedStorage scopedStorage, @NonNull File file) {
        Context context = scopedStorage.getContext();
        String authorities = scopedStorage.getAuthorities();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(context, authorities, file);
        } else {
            return Uri.fromFile(file);
        }
    }

    /**
     * 授予读权限
     *
     * @param context
     * @param uri
     */
    public static void grantReadPermission(Context context, String packageName, Uri uri) {
        context.grantUriPermission(packageName, uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
    }

    /**
     * 授予写权限
     *
     * @param context
     * @param uri
     */
    public static void grantWritePermission(Context context, String packageName, Uri uri) {
        context.grantUriPermission(packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

    }

    /**
     * 授予读写权限
     *
     * @param context
     * @param uri
     */
    public static void grantReadWritePermission(Context context, String packageName, Uri uri) {
        context.grantUriPermission(packageName, uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

    }

    /**
     * 撤销所有权限
     *
     * @param context
     * @param packageName API26以下忽略此参数
     * @param uri
     */
    public static void revokeReadPermission(Context context, String packageName, Uri uri) {
        revokePermission(context, packageName, uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
    }

    /**
     * 撤销所有权限
     *
     * @param context
     * @param packageName API26以下忽略此参数
     * @param uri
     */
    public static void revokeWritePermission(Context context, String packageName, Uri uri) {
        revokePermission(context, packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
    }

    /**
     * 撤销所有权限
     *
     * @param context
     * @param packageName API26以下忽略此参数
     * @param uri
     */
    public static void revokeReadWritePermission(Context context, String packageName, Uri uri) {
        revokePermission(context, packageName, uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
    }

    /**
     * 撤销所有权限
     *
     * @param context
     * @param packageName API26以下忽略此参数
     * @param uri
     */
    public static void revokePermission(Context context, String packageName, Uri uri, int flags) {
        if (TextUtils.isEmpty(packageName) || Build.VERSION.SDK_INT < 26) {
            context.revokeUriPermission(uri, flags);
        } else {
            context.revokeUriPermission(packageName, uri, flags);
        }
    }
}
