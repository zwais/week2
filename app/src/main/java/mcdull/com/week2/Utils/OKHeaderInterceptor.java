package mcdull.com.week2.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import mcdull.com.week2.base.BaseApplication;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OKHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences sp = BaseApplication.sContext.getSharedPreferences("user", Context.MODE_PRIVATE);
        String sid = sp.getString("sid", "");
        int uid = sp.getInt("uid", 0);
        Request request=chain.request();
        Request.Builder builder=request.newBuilder();
        builder.addHeader("userId",uid+"");
        builder.addHeader("sessionId",sid);
        request=builder.build();
        return chain.proceed(request);
    }
}
