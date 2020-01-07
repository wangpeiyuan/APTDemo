package com.wangpeiyuan.viewbinding.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public interface Provider {
    Context getContext(Object source);

    View findView(Object source, int id);
}
