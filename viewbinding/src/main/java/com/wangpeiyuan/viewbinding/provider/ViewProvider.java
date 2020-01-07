package com.wangpeiyuan.viewbinding.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public class ViewProvider implements Provider {
    @Override
    public Context getContext(Object source) {
        return ((View) source).getContext();
    }

    @Override
    public View findView(Object source, int id) {
        return ((View) source).findViewById(id);
    }
}
