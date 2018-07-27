package com.example.admin.classification_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.classification_recyclerview.activity.ShowActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button main_btn;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        main_btn = findViewById(R.id.main_btn);
        initListener();
    }

    private void initListener() {
        main_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View pView) {
        switch (pView.getId()){
            case R.id.main_btn:
                mIntent = new Intent(MainActivity.this, ShowActivity.class);
                mIntent.putExtra("number","33");
                startActivity(mIntent);
                break;
        }
    }
}
