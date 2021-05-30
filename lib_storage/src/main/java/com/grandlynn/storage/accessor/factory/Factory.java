package com.grandlynn.storage.accessor.factory;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.accessor.Accessor;
import com.grandlynn.storage.filetype.base.FileType;

/**
 * Created by rookie
 * on 2021-05-13 上午11:35
 */
public interface Factory {
    Accessor newAccessor(ScopedStorage scopedStorage, FileType fileType);
}
