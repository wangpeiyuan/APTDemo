package com.wangpeiyuan.viewbinding_compiler;

import com.squareup.javapoet.ClassName;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public class TypeUtil {
    public static final ClassName ANDROID_VIEW = ClassName.get("android.view", "View");
    public static final ClassName ANDROID_ON_CLICK_LISTENER = ClassName.get("android.view", "View", "OnClickListener");
    public static final ClassName VIEW_INJECTOR = ClassName.get("com.wangpeiyuan.viewbinding", "ViewInjector");
    public static final ClassName PROVIDER = ClassName.get("com.wangpeiyuan.viewbinding.provider", "Provider");
}
