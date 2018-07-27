package com.example.admin.classification_recyclerview.model;

import android.util.Log;

import com.example.admin.classification_recyclerview.bean.FoodBean;
import com.example.admin.classification_recyclerview.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author:admin
 * Date:2018-7-26 20:37
 * Project：Classification_RecyclerView
 */
public class Model {
    private static final String TAG = "Model";
    public void getData(final Imodel pImodel, int id){
        OkHttpUtils.doGet("http://39.108.3.12:3000/v1/food/" + id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "onFailure: model里面失败了");
                pImodel.model_onfail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onFailure: model里面成功了");
                String _s = response.body().string();
                FoodBean _foodBean = new Gson().fromJson(_s, FoodBean.class);
                pImodel.model_onsuccess(_foodBean);
            }
        });
    }
}
