package com.example.admin.classification_recyclerview.view;

import com.example.admin.classification_recyclerview.bean.FoodBean;

/**
 * author:admin
 * Date:2018-7-26 20:37
 * Project：Classification_RecyclerView
 */
public interface Iview {
    void view_onsuccess(FoodBean pFoodBean);

    void view_onfail(int code);
}
