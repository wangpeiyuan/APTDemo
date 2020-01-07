package com.wangpeiyuan.viewbinding;

import android.app.Activity;
import android.view.View;

import com.wangpeiyuan.viewbinding.provider.ActivityProvider;
import com.wangpeiyuan.viewbinding.provider.Provider;
import com.wangpeiyuan.viewbinding.provider.ViewProvider;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public class ViewBinding {
    private static final ActivityProvider PROVIDER_ACTIVITY = new ActivityProvider();
    private static final ViewProvider PROVIDER_VIEW = new ViewProvider();

    private static final Map<String, ViewInjector> VIEW_INJECTOR_MAP = new HashMap<>();

    public static void inject(Activity activity) {
        inject(activity, activity, PROVIDER_ACTIVITY);
    }

    public static void inject(View view) {
        inject(view, view);
    }

    public static void inject(Object host, View view) {
        inject(host, view, PROVIDER_VIEW);
    }

    public static void inject(Object host, Object source, Provider provider) {
        Class<?> cls = host.getClass();
        String className = cls.getName();
        ViewInjector viewInjector = VIEW_INJECTOR_MAP.get(className);
        if (viewInjector == null) {
            try {
                Class<?> viewInjectorClass = cls.getClassLoader().loadClass(className + "_ViewBinding");
                viewInjector = (ViewInjector) viewInjectorClass.newInstance();
                VIEW_INJECTOR_MAP.put(className, viewInjector);
                viewInjector.inject(host, source, provider);
            } catch (Exception e) {
                throw new RuntimeException("Unable to inject for " + className, e);
            }
        }
    }
}
