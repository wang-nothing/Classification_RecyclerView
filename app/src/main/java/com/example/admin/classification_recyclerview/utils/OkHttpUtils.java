package com.example.admin.classification_recyclerview.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * author:admin
 * Date:2018-7-26 20:37
 * Project：Classification_RecyclerView
 */
public class OkHttpUtils {

    private static OkHttpClient client = null;

    public OkHttpUtils(){

    }

    public static OkHttpClient getInstance(){
        if (client == null){
            synchronized (OkHttpUtils.class){
                if (client == null){
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }
    public static void doGet(String url, Callback callback){
        Request _request = new Request.Builder()
                .url(url)
                .build();
        Call call = getInstance().newCall(_request);
        call.enqueue(callback);
    }
}
