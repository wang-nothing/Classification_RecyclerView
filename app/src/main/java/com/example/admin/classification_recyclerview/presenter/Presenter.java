package com.example.admin.classification_recyclerview.presenter;

import com.example.admin.classification_recyclerview.activity.ShowActivity;
import com.example.admin.classification_recyclerview.bean.FoodBean;
import com.example.admin.classification_recyclerview.model.Imodel;
import com.example.admin.classification_recyclerview.model.Model;
import com.example.admin.classification_recyclerview.view.Iview;

/**
 * author:admin
 * Date:2018-7-26 20:37
 * Project：Classification_RecyclerView
 */
public class Presenter implements Ipresenter {
    private Iview mIview;
    private Model mModel;

    public Presenter(Iview pIview) {
        this.mIview = pIview;
        mModel = new Model();
    }
    public void getDatas(int id){
        mModel.getData(new Imodel() {
            @Override
            public void model_onsuccess(FoodBean pFoodBean) {
                mIview.view_onsuccess(pFoodBean);
            }

            @Override
            public void model_onfail(int code) {
                mIview.view_onfail(code);
            }
        },id);
    }
    @Override
    public void presenter_onDestroys() {
        if (mIview != null){
            mIview = null;
        }
    }
}
