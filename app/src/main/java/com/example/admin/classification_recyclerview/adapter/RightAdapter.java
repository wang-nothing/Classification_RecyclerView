package com.example.admin.classification_recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.classification_recyclerview.R;
import com.example.admin.classification_recyclerview.bean.FoodBean;
import com.example.admin.classification_recyclerview.holder.LeftHolder;
import com.example.admin.classification_recyclerview.holder.RightHolder;

import java.util.List;

/**
 * author:admin
 * Date:2018-7-26 20:57
 * Project：Classification_RecyclerView
 */
public class RightAdapter extends RecyclerView.Adapter<RightHolder> implements View.OnClickListener {
    private Context mContext;
    private List<FoodBean.DataBean.SpusBean> mSpus;
    private View mView;

    public RightAdapter(Context pContext, List<FoodBean.DataBean.SpusBean> pSpus) {
        mContext = pContext;
        mSpus = pSpus;
    }

    @NonNull
    @Override
    public RightHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_right, null);
        mView.setOnClickListener(this);
        return new RightHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RightHolder pRightHolder, int pI) {
        String _name = mSpus.get(pI).getName();
        String _month_saled_content = mSpus.get(pI).getMonth_saled_content();
        String _pic_url = mSpus.get(pI).getPic_url();
        Glide.with(mContext).load(_pic_url).into(pRightHolder.item_right_image);
        pRightHolder.item_right_title.setText(_name);
        pRightHolder.item_right_content.setText(_month_saled_content);
    }

    @Override
    public int getItemCount() {
        return mSpus.size();
    }

    @Override
    public void onClick(View pView) {

    }
    private onItemRightclick mOnItemRightclick;

    public RightAdapter(onItemRightclick pOnItemRightclick) {
        mOnItemRightclick = pOnItemRightclick;
    }
    public interface onItemRightclick{
        void item(int pI);
    }
}
