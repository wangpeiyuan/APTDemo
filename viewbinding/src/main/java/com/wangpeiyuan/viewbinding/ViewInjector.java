package com.wangpeiyuan.viewbinding;

import com.wangpeiyuan.viewbinding.provider.Provider;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public interface ViewInjector<T> {
    void inject(T host, Object source, Provider provider);
}
