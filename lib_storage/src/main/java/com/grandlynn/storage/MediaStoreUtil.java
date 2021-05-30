package com.grandlynn.storage;

import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

import java.util.Set;

/**
 * MediaStore提供了下列几种类型的访问Uri，通过查找对应Uri数据，达到访问的目的。
 * 下列每种类型又分为三种Uri，Internal、External、可移动存储:
 *
 * ●Audio
 *    ■  Internal: MediaStore.Audio.Media.INTERNAL_CONTENT_URI
 *
 *        content://media/internal/audio/media。
 *
 *    ■  External: MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
 *
 *        content://media/external/audio/media。
 *
 *    ■  可移动存储: MediaStore.Audio.Media.getContentUri
 *
 *        content://media/<volumeName>/audio/media。
 * ●  Video
 *    ■    Internal: MediaStore.Video.Media.INTERNAL_CONTENT_URI
 *          content://media/internal/video/media。
 *    ■    External: MediaStore.Video.Media.EXTERNAL_CONTENT_URI
 *          content://media/external/video/media。
 *    ■    可移动存储: MediaStore.Video.Media.getContentUri
 *          content://media/<volumeName>/video/media。
 * ●  Image
 *    ■    Internal: MediaStore.Images.Media.INTERNAL_CONTENT_URI
 *          content://media/internal/images/media。
 *    ■    External: MediaStore.Images.Media.EXTERNAL_CONTENT_URI
 *          content://media/external/images/media。
 *    ■    可移动存储: MediaStore.Images.Media.getContentUri
 *          content://media/<volumeName>/images/media。
 * ●  File
 *    ■    MediaStore. Files.Media.getContentUri
 *          content://media/<volumeName>/file。
 * ●  Downloads
 *    ■    Internal: MediaStore.Downloads.INTERNAL_CONTENT_URI
 *          content://media/internal/downloads。
 *    ■    External: MediaStore.Downloads.EXTERNAL_CONTENT_URI
 * content://media/external/downloads。
 *    ■    可移动存储: MediaStore.Downloads.getContentUri
 * content://media/<volumeName>/downloads。
 */
public class MediaStoreUtil {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public Set<String> getAllVolumes(Context context) {
        return MediaStore.getExternalVolumeNames(context);
    }



}
