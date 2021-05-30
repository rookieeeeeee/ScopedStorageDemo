package com.grandlynn.storage.filetype.legacy;

import com.grandlynn.storage.filetype.base.FileType;

import java.io.File;

/**
 * 对于分区存储：此对象表示只能用于以下两个目录的FileType
 * /sdcard/Android/data
 * /data/data/<PackageName>/
 * 对于传统存储：无限制
 * <p>
 * Created by rookie
 * on 2021-05-13 上午11:30
 */
public class LegacyFile extends FileType {

    /**
     * 这里要传相对路径
     *
     * @param fileName
     */
    public LegacyFile(String fileName) {
        super(fileName);
    }

    public LegacyFile(File file) {
        super(file.getPath());
    }

    @Override
    public String getMimeType() {
        return null;
    }
}
