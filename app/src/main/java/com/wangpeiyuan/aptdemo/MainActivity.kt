package com.wangpeiyuan.aptdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wangpeiyuan.viewbinding_annnotation.BindView

class MainActivity : AppCompatActivity() {
    @BindView(R.id.tv_desc)
    lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
