package com.heytea.allpay;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Package     ：com.heytea.allpay
 * Description ：
 * Company     ：Heytea
 * Author      ：Created by ChengGuang
 * CreateTime  ：2020/5/27.
 */
public class RNAllPayPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        return Arrays.asList(new NativeModule[]{
                new RNAllPayModule(reactContext),
        });
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return Collections.emptyList() ;
    }
}
