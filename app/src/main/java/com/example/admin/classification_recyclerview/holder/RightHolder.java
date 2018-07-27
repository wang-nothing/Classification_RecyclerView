package com.example.admin.classification_recyclerview.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.classification_recyclerview.R;

/**
 * author:admin
 * Date:2018-7-26 20:57
 * Project：Classification_RecyclerView
 */
public class RightHolder extends RecyclerView.ViewHolder {
    public TextView item_right_title,item_right_content,item_right_price;
    public ImageView item_right_image;
    public RightHolder(@NonNull View itemView) {
        super(itemView);
        item_right_title = itemView.findViewById(R.id.item_right_title);
        item_right_content = itemView.findViewById(R.id.item_right_content);
        item_right_price = itemView.findViewById(R.id.item_right_price);
        item_right_image = itemView.findViewById(R.id.item_right_image);
    }
}
