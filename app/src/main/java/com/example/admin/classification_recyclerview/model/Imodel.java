package com.example.admin.classification_recyclerview.model;

import com.example.admin.classification_recyclerview.bean.FoodBean;

/**
 * author:admin
 * Date:2018-7-26 20:37
 * Project：Classification_RecyclerView
 */
public interface Imodel {
    void model_onsuccess(FoodBean pFoodBean);

    void model_onfail(int code);
}
