package com.example.administrator.indicatorframe.utils;

import android.util.Log;

import com.example.administrator.indicatorframe.bean.FeaturedBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wanxin on 2016-08-12.
 */
public class HttpUtils {
    private static HttpUtils instance ;

    public HttpUtils() {
    }

    public static synchronized HttpUtils getInstance(){
        if(instance == null){
            instance = new HttpUtils();
        }
        return instance ;
    }

    public interface HttpCallBack<T> {
        public void onSucess(T t);

    }

    public void getJsonData(final HashMap<String, String> params, final HttpCallBack<FeaturedBean> httpCallBack){
        Call<FeaturedBean> featuredBeanCallback = RetrofitHelper
                .getInstance()
                .createRetrofitService(GetBeanService.class)
                .getBean(params);
        featuredBeanCallback.enqueue(new Callback<FeaturedBean>() {
            @Override
            public void onResponse(Call<FeaturedBean> call, Response<FeaturedBean> response) {
                FeaturedBean featuredBean = response.body();
//                //能运行到这一步就说明文件肯定是不存在的了 所以解析完数据直接到问价里就好了
//                File fileDir = new File(SDCardUtils.getSDCardPath() + "featured");
//                File file = new File(SDCardUtils.getSDCardPath() + "featured" + File.separator + params.get(UrlConfig.PublicKey.PAGE_SIZE) + ".txt");
//                if (!fileDir.exists()) {
//                    fileDir.mkdir();
//                }
//                try {
//                    file.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Log.i("SD", "" + file.isFile());
//                Gson gson = new Gson();
//                String json = gson.toJson(response.body(), FeaturedBean.class);
//                Log.i("SD", "fffffff" + SDCardUtils.getSDCardPath());
//
//                byte[] bytes = json.getBytes();
//                try {
//                    FileOutputStream fo = new FileOutputStream(file);
//                    fo.write(bytes, 0, bytes.length);
//                    fo.flush();
//                    Log.i("SD", file.exists() + "" + file.getAbsolutePath());
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                httpCallBack.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<FeaturedBean> call, Throwable t) {
                Log.i("TAG...........","网络异常");
            }
        });
    }

}
