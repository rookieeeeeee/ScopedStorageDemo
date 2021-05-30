package com.grandlynn.storage.accessor;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.filetype.base.FileType;

/**
 * Created by rookie
 * on 2021-05-13 上午11:06
 */
public abstract class AbsAccessor implements Accessor {

    protected FileType      mFileType;
    protected ScopedStorage mScopedStorage;

    public AbsAccessor(ScopedStorage scopedStorage, FileType fileType) {
        mFileType      = fileType;
        mScopedStorage = scopedStorage;
    }
}
