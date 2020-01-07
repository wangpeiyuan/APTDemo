package com.wangpeiyuan.viewbinding.provider;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public class ActivityProvider implements Provider {
    @Override
    public Context getContext(Object source) {
        return ((Activity) source);
    }

    @Override
    public View findView(Object source, int id) {
        return ((Activity) source).findViewById(id);
    }
}
