package com.example.administrator.indicatorframe.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ======================================
 * 版权：daidai
 * 版本：1.0
 * 创建日期：2016-8-9
 * 描述：把流对象写到客户端，返回服务器的json数据
 * =======================================
 */
public class StreamUtils {

    private static ByteArrayOutputStream baos;

    public static String readStream(InputStream is){


        try {
            //获取一个写的流对象
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
                baos.flush();
            }

            return new String(baos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos!= null)
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return "";
    }
}
