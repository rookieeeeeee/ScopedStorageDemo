package com.grandlynn.storage.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;

import java.io.File;
import java.util.List;

import static android.content.pm.PackageManager.MATCH_DEFAULT_ONLY;

/**
 * Created by rookie
 * on 19-9-8 at 下午3:26
 */
public class IntentUtil {

    public static Intent openFile(@NonNull Context context, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) return null;
        /* 取得扩展名 */
        String end = file.getName().substring(file.getName().lastIndexOf(".") + 1).toLowerCase();
        /* 依扩展名的类型决定MimeType */
        Intent intent;
        if (end.equals("m4a") || end.equals("mp3") || end.equals("mid") ||
                end.equals("xmf") || end.equals("ogg") || end.equals("wav")) {
            intent = getAudioFileIntent(context, filePath);
        } else if (end.equals("3gp") || end.equals("mp4")) {
            intent = getAudioFileIntent(context, filePath);
        } else if (end.equals("jpg") || end.equals("gif") || end.equals("png") ||
                end.equals("jpeg") || end.equals("bmp")) {
            intent = getImageFileIntent(context, filePath);
        } else if (end.equals("apk")) {
            intent = getApkFileIntent(context, filePath);
        } else if (end.equals("ppt") || end.equals("pptx")) {
            intent = getPptFileIntent(context, filePath);
        } else if (end.equals("xls") || end.equals("xlsx")) {
            intent = getExcelFileIntent(context, filePath);
        } else if (end.equals("doc") || end.equals("docx")) {
            intent = getWordFileIntent(context, filePath);
        } else if (end.equals("pdf")) {
            intent = getPdfFileIntent(context, filePath);
        } else if (end.equals("chm")) {
            intent = getChmFileIntent(context, filePath);
        } else if (end.equals("txt")) {
            intent = getTextFileIntent(context, filePath, false);
        } else {
            intent = getAllIntent(context, filePath);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            List<ResolveInfo> resolveInfos = context
                    .getPackageManager()
                    .queryIntentActivities(intent, MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resolveInfos) {
                context.grantUriPermission(resolveInfo.activityInfo.packageName, intent.getData(), Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        }
        return intent;
    }

    private static Uri getCompatUri(Context context, String path) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".fp", new File(path));
        } else {
            return Uri.fromFile(new File(path));
        }
    }


    //Android获取一个用于打开APK文件的intent
    public static Intent getAllIntent(@NonNull Context context, String param) {

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "*/*");
        return intent;
    }

    //Android获取一个用于打开APK文件的intent
    public static Intent getApkFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
    }

    //Android获取一个用于打开VIDEO文件的intent
    public static Intent getVideoFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "video/*");
        return intent;
    }

    //Android获取一个用于打开AUDIO文件的intent
    public static Intent getAudioFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }

    //Android获取一个用于打开Html文件的intent
    public static Intent getHtmlFileIntent(@NonNull Context context, String param) {
        Uri uri = getCompatUri(context, param)
                .buildUpon()
                .encodedAuthority("com.android.htmlfileprovider")
                .scheme("content")
                .encodedPath(param)
                .build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");
        return intent;
    }

    //Android获取一个用于打开图片文件的intent
    public static Intent getImageFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "image/*");
        return intent;
    }

    //Android获取一个用于打开PPT文件的intent
    public static Intent getPptFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }

    //Android获取一个用于打开Excel文件的intent
    public static Intent getExcelFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "application/vnd.ms-excel");
        return intent;
    }

    //Android获取一个用于打开Word文件的intent
    public static Intent getWordFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "application/msword");
        return intent;
    }

    //Android获取一个用于打开CHM文件的intent
    public static Intent getChmFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "application/x-chm");
        return intent;
    }

    //Android获取一个用于打开文本文件的intent
    public static Intent getTextFileIntent(@NonNull Context context, String param, boolean paramBoolean) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri1 = getCompatUri(context, param);
        intent.setDataAndType(uri1, "text/plain");
        return intent;
    }

    //Android获取一个用于打开PDF文件的intent
    public static Intent getPdfFileIntent(@NonNull Context context, String param) {

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = getCompatUri(context, param);
        intent.setDataAndType(uri, "application/pdf");
        return intent;
    }

    public static Intent getDocumentIntent(DocumentFile documentFile) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(documentFile.getUri(), documentFile.getType());
        return intent;
    }
}
