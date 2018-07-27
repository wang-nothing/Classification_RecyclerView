package com.example.admin.classification_recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.classification_recyclerview.MainActivity;
import com.example.admin.classification_recyclerview.R;
import com.example.admin.classification_recyclerview.adapter.LeftAdapter;
import com.example.admin.classification_recyclerview.adapter.RightAdapter;
import com.example.admin.classification_recyclerview.bean.FoodBean;
import com.example.admin.classification_recyclerview.presenter.Presenter;
import com.example.admin.classification_recyclerview.view.Iview;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements Iview {
    private static final String TAG = "ShowActivity";
    private RecyclerView left_recycler,right_recycler;
    private int id;
    private List<FoodBean.DataBean> mData;
    private LeftAdapter mLeftAdapter;
    private List<FoodBean.DataBean.SpusBean> mSpus;
    private RightAdapter mRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initDatas();
        initViews();
        new Presenter(this).getDatas(id);
    }

    private void initDatas() {
        Intent _intent = getIntent();
        String _number = _intent.getStringExtra("number");
        int _i = Integer.parseInt(_number);
        id = _i;
        Log.i(TAG, "ShowActivity里面的id值: "+id);
    }

    private void initViews() {
        left_recycler = findViewById(R.id.left_recycler);
        right_recycler = findViewById(R.id.right_recycler);
        initConfig();
    }

    private void initConfig() {
        left_recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        right_recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        left_recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        right_recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    @Override
    public void view_onsuccess(FoodBean pFoodBean) {
        mData = pFoodBean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mLeftAdapter = new LeftAdapter(ShowActivity.this, mData);
                left_recycler.setAdapter(mLeftAdapter);
                mLeftAdapter.setmItemClickListener(new LeftAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int i) {
                        mSpus = mData.get(i).getSpus();
                        Log.i(TAG, "onItemClick: "+i);
                        mRightAdapter = new RightAdapter(ShowActivity.this, mSpus);
                        right_recycler.setAdapter(mRightAdapter);
                    }
                });
            }
        });
    }

    @Override
    public void view_onfail(int code) {

    }
}
