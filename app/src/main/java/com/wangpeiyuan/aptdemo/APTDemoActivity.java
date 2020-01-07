package com.wangpeiyuan.aptdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wangpeiyuan.viewbinding.ViewBinding;
import com.wangpeiyuan.viewbinding_annnotation.BindView;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public class APTDemoActivity extends AppCompatActivity {

    @BindView(R.id.tv_desc)
    TextView tvDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewBinding.inject(this);
    }
}
