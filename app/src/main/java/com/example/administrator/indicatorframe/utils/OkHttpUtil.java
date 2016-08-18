package com.example.administrator.indicatorframe.utils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by zhangke on 16/7/14.
 */
public class OkHttpUtil {

    private static OkHttpClient okHttpClient;
    private Context context;

    //okhttp7条步骤全部私有化

    private OkHttpUtil(Context context) {
        this.context = context;
        if(okHttpClient==null){
        this.okHttpClient = new OkHttpClient();
        }
        //用2.75版本可以设置超时和缓存
//        okHttpClient.setConnectTimeout(20, TimeUnit.SECONDS);
//        okHttpClient.setReadTimeout(15,TimeUnit.SECONDS);
//        okHttpClient.setWriteTimeout(15,TimeUnit.SECONDS);
//        //缓存
//        okHttpClient.setCache(new Cache(context.getCacheDir(),1024*1024*10));

    }

    //请求对象私有化
    private Request getRequest(String url){

        Request.Builder builder=new Request.Builder();
        builder.url(url);
        return  builder.build();
    }
    //相应对象私有化
    private Response getResponse(String url) throws IOException {
        Request request=getRequest(url);
      return    okHttpClient.newCall(request).execute();

    }
    //相应体
    private ResponseBody getResponseBody(String url) throws IOException {

        ResponseBody body=getResponse(url).body();
        return  body;
    }


    //get同步请求异步请求
    public  static  String  getRequestExe(String url,Context context) throws IOException {
        return  new OkHttpUtil(context).getResponseBody(url).string();

    }


    //get同步请求异步请求
    public  static byte[] getRequestExe1(String url, Context context) throws IOException {
        return  new OkHttpUtil(context).getResponseBody(url).bytes();

    }
    //get同步请求异步请求
    public  static  void  getRequestEnq(String url, Context context, Callback callback)  {

        Request request=new OkHttpUtil(context).getRequest(url);

        okHttpClient.newCall(request).enqueue(callback);
    }


}
