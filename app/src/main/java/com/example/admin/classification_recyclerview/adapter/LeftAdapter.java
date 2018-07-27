package com.example.admin.classification_recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.classification_recyclerview.R;
import com.example.admin.classification_recyclerview.bean.FoodBean;
import com.example.admin.classification_recyclerview.holder.LeftHolder;

import java.util.List;

/**
 * author:admin
 * Date:2018-7-26 20:57
 * Project：Classification_RecyclerView
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftHolder> implements View.OnClickListener {
    private Context mContext;
    private List<FoodBean.DataBean> mData;
    private View mView;

    public LeftAdapter(Context pContext, List<FoodBean.DataBean> pData) {
        mContext = pContext;
        mData = pData;
    }

    @NonNull
    @Override
    public LeftHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_left, null);
        mView.setOnClickListener(this);
        return new LeftHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftHolder pLeftHolder, int pI) {
        String _name = mData.get(pI).getName();
        pLeftHolder.item_left_tv.setText(_name);
        pLeftHolder.itemView.setTag(pI);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    private OnItemClickListener mItemClickListener;

    public void setmItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {
        if (mItemClickListener != null){
            mItemClickListener.onItemClick((Integer) view.getTag());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int i);
    }

}
