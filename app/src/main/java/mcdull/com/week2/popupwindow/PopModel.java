package mcdull.com.week2.popupwindow;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import mcdull.com.week2.ICallBack;
import mcdull.com.week2.Utils.OkHttpUtils;
import mcdull.com.week2.bean.UtilsUrl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class PopModel {
    Handler handler=new Handler();
    public void getFirst( final ICallBack callBack, final Type type){
        OkHttpUtils.enqueuGet(UtilsUrl.firstCategoryUrl, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      callBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(result, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      callBack.successful(o);
                    }
                });
            }
        },type);
    }
    public void getSecond(String firstCategoryId,final ICallBack callBack, final Type type){
        String url=UtilsUrl.secondCategoryUrl+"?firstCategoryId="+firstCategoryId;
        OkHttpUtils.enqueuGet(url,new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(result, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.successful(o);
                    }
                });
            }
        },type);
    }
    public void getCommodityByCategory(String categoryId,int page,int count,final ICallBack callBack, final Type type){
        String url=UtilsUrl.commodityByCategoryUrl+"?categoryId="+categoryId+"&page="+page+"&count="+count;
        OkHttpUtils.enqueuGet(url,new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(result, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.successful(o);
                    }
                });
            }
        },type);
    }
}
