package mcdull.com.week2.base;

import android.app.Application;
import android.content.Context;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import mcdull.com.week2.Utils.LogUtil;
import mcdull.com.week2.Utils.OkHttpUtils;
public class BaseApplication extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        DiskCacheConfig.Builder builder = DiskCacheConfig.newBuilder(this);
        builder.setBaseDirectoryPath(getCacheDir());
        DiskCacheConfig config = builder.build();
        ImagePipelineConfig build = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(config)
                .build();
        Fresco.initialize(this,build);
        sContext=this;
        LogUtil.init();
        initHttpHeader();
    }

    private void initHttpHeader() {

        OkHttpUtils.init();
    }
}
