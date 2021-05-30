package com.grandlynn.storage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

import com.grandlynn.storage.accessor.Accessor;
import com.grandlynn.storage.accessor.factory.Factory;
import com.grandlynn.storage.datastore.PreferenceDataStore;
import com.grandlynn.storage.datastore.ProtoDataStore;
import com.grandlynn.storage.filetype.base.FileType;
import com.grandlynn.storage.provider.FileProvider;
import com.grandlynn.storage.provider.Provider;
import com.grandlynn.storage.share.Share;
import com.grandlynn.storage.share.SimpleShare;

import java.io.File;
import java.io.IOException;

/*******************************************************************************
 *                                                                             *
 *                                  分区存储                                    *
 *                                                                             *
 *******************************************************************************
 *      //初始化
 *      ScopedStorage scopedStorage = new ScopedStorage.Config()
 *                 .legacyMode(ScopedStorage.LegacyMode.MODE_EXTERNAL_STORAGE)
 *                 .prefix("/sdcard/xxx")
 *                 .preference("mypreferce.pf")
 *                 .workdir("${app_name}")
 *                 .accessorFactory((storage, fileType) -> {
 *                     return null;
 *                 })
 *                 .buildStorage(context);
 *
 *         //saf操作
 *         ActivityResultContracts.OpenDocument openDocument = Saf.openFile(activity, "image/*");
 *         Uri safUri = openDocument.parseResult(resultCode, data);
 *         Accessor access = scopedStorage.access(new SafFile(safUri.toString(),false));
 *
 *
 *         //MediaStore API
 *         Accessor access = scopedStorage.access(new MediaAudio(mediaUri));
 *
 *
 *         //LegacyStorage API
 *         Accessor access = scopedStorage.access(new LegacyFile("foo/foo.txt"));
 *         if (access.exists()) {
 *             InputStream inputStream = access.getInputStream();
 *             OutputStream outputStream = access.getOutputStream();
 *         }
 *
 *
 *
 *         //Open File by FileProvider
 *         Provider provide = scopedStorage.provide();
 *         provide.provideFile(new File("/data/data/<PackageName>/files/foo.mp3"));
 *
 *
 *
 *         //share File by Sharesheet
 *         Share share = scopedStorage.share();
 *         share.shareFile("foo",fileUri,"image/jpeg");
 *
 * ************************************************************************************
 * Created by rookie
 * on 2021-05-13 上午10:06
 */
public class ScopedStorage {

    private Config            mConfig;
    private SharedPreferences mPreferences;


    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void requestManageStorage(Context context){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
        context.startActivity(intent);
    }

    private ScopedStorage(Config config) {
        mConfig = config;
        if (!TextUtils.isEmpty(config.preferenceFileName))
            PreferenceDataStore.Companion.create(new File(config.preferenceFileName));
        if (!TextUtils.isEmpty(config.protoFileName))
            ProtoDataStore.Companion.create(new File(config.protoFileName));
        if (!TextUtils.isEmpty(config.preferenceFileName))
            mPreferences = getContext().getSharedPreferences(mConfig.preferenceFileName, Context.MODE_PRIVATE);
    }

    public Accessor access(FileType fileType) {
        return FileAccessor.access(this, fileType);
    }

    public Share share() {
        return new SimpleShare(this);
    }

    public Provider provide() {
        return new FileProvider(this);
    }

    public SharedPreferences preference() {
        return mPreferences;
    }

    public Factory getFactory() {
        return mConfig.factory;
    }

    public Context getContext() {
        return mConfig.context;
    }

    public String getPrefix() {
        return mConfig.prefix;
    }

    public String getWorkDir() {
        return mConfig.workDir;
    }

    public String getAuthorities() {
        return mConfig.authorities;
    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void checkAvailableStorage(Context context, String path, long desireBytes) throws IOException {
//        StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
//        UUID uuidForPath = storageManager.getUuidForPath(new File(path));
//        long allocatableBytes = storageManager.getAllocatableBytes(uuidForPath);
//        if (allocatableBytes < desireBytes) {
//            Intent intent = new Intent(ACTION_MANAGE_STORAGE);
//            context.startActivity(intent);
//        } else {
//            storageManager.allocateBytes(uuidForPath, desireBytes);
//        }
//    }

    public enum LegacyMode {
        /**
         * Context.getFiles();
         */
        MODE_INTERNAL_FILE,
        /**
         * Context.getCache();
         */
        MODE_INTERNAL_CACHE,
        /**
         * Context.getExternalFiles();
         */
        MODE_EXTERNAL_FILE,
        /**
         * Context.getExternalCache()
         */
        MODE_EXTERNAL_CACHE,
        /**
         * Environment.getExternalStorageDirectory()
         */
        MODE_EXTERNAL_STORAGE
    }

    public static class Config {
        private String prefix;
        //存储的Root
        private String workDir;

        private Factory factory;

        private String preferenceFileName;

        private String protoFileName;

        private LegacyMode legacyMode;

        private Context context;

        private String authorities;

        public Config() { }

        public Config prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Config legacyMode(LegacyMode legacyMode) {
            this.legacyMode = legacyMode;
            return this;
        }

        public Config workdir(String root) {
            workDir = root;
            return this;
        }

//        public Config proto(String fileName) {
//            protoFileName = fileName;
//            return this;
//        }

        public Config preference(String fileName) {
            preferenceFileName = fileName;
            return this;
        }

        public Config accessorFactory(Factory factory) {
            this.factory = factory;
            return this;
        }

        public ScopedStorage buildStorage(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context 不能为Null！");
            }

            this.context = context;


            String rawPrefix;

            if (legacyMode == LegacyMode.MODE_INTERNAL_FILE) {
                rawPrefix = context.getFilesDir().getAbsolutePath();
            } else if (legacyMode == LegacyMode.MODE_INTERNAL_CACHE) {
                rawPrefix = context.getCacheDir().getAbsolutePath();
            } else if (legacyMode == LegacyMode.MODE_EXTERNAL_FILE) {
                rawPrefix = context.getExternalFilesDir("").getAbsolutePath();
            } else if (legacyMode == LegacyMode.MODE_EXTERNAL_CACHE) {
                rawPrefix = context.getExternalCacheDir().getAbsolutePath();
            } else if (legacyMode == LegacyMode.MODE_EXTERNAL_STORAGE) {
                rawPrefix = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else if (!TextUtils.isEmpty(prefix)) {
                rawPrefix = prefix;
            } else {
                throw new IllegalStateException("请配置Prefix或者LegacyMode!");
            }

            if (legacyMode == LegacyMode.MODE_EXTERNAL_STORAGE){
                if (!TextUtils.isEmpty(workDir)) {
                    try {
                        prefix = new File(rawPrefix, workDir).getCanonicalPath();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getCause());
                    }
                }
            }

            authorities = context.getPackageName() + BuildConfig.authoritiesSuffix;
            return new ScopedStorage(this);
        }

    }
}
