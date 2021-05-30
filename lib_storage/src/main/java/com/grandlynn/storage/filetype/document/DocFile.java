package com.grandlynn.storage.filetype.document;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

import com.grandlynn.storage.filetype.base.FileType;
import com.grandlynn.storage.filetype.mediastore.MediaBase;
import com.grandlynn.storage.filetype.mediastore.MediaFile;

/**
 * 通过SAF选择的文件/目录可以用此类包装并交由SafAccessor处理
 * Uri uri = Saf.openFile(activity,null).parseResult(resultCode,data);
 * Accessor accessor = FileAccessor.newInstance(new SafFile(uri.toString()));
 * 至此，可以通过Accessor来像操作File一样操作DocumentFile了
 * <p>
 * Created by rookie
 * on 2021-05-13 下午4:12
 */
public class DocFile extends FileType {

    public DocFile(String uri) {
        super(uri);

    }

    @Override
    public String getMimeType() {
        return "*/*";
    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    public MediaBase converToMediaType(Context context){
        return new MediaFile(/*MediaStore.getMediaUri(context, Uri.parse(mFileName)).toString()*/"", MediaFile.MediaType.MEDIA_TYPE_AUDIO);
    }

}
