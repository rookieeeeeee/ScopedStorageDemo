package com.grandlynn.storage.accessor.factory;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.accessor.Accessor;
import com.grandlynn.storage.accessor.DocumentAccessor;
import com.grandlynn.storage.accessor.LegacyAccessor;
import com.grandlynn.storage.accessor.MediaStoreAccessor;
import com.grandlynn.storage.filetype.base.FileType;
import com.grandlynn.storage.filetype.legacy.LegacyFile;
import com.grandlynn.storage.filetype.document.DocFile;
import com.grandlynn.storage.filetype.mediastore.MediaBase;

/**
 * Created by rookie
 * on 2021-05-13 上午11:00
 */
public class AccessorFactory implements Factory {

    public Accessor newAccessor(ScopedStorage scopedStorage, FileType type) {
        Accessor accessor = null;
        Factory factory = scopedStorage.getFactory();
        if (factory != null) {
            accessor = factory.newAccessor(scopedStorage,type);
        }
        if (accessor == null) {
            if (type instanceof LegacyFile) {
                accessor = new LegacyAccessor(scopedStorage,type);
            } else if (type instanceof DocFile) {
                accessor = new DocumentAccessor(scopedStorage,type);
            } else if (type instanceof MediaBase/*Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && !Environment.isExternalStorageLegacy()*/) {
                accessor = new MediaStoreAccessor(scopedStorage, (MediaBase) type);
            } else {
                accessor = new LegacyAccessor(scopedStorage,type);
            }
        }
        return accessor;
    }

}
