package com.heytea.allpay;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.allpayx.sdk.AllPayEngine;
import com.allpayx.sdk.util.HttpUtil;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.heytea.allpay.util.JsonUtil;
import com.heytea.allpay.util.PayUtil;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * Package     ：com.heytea.allpay
 * Description ：
 * Company     ：Heytea
 * Author      ：Created by ChengGuang
 * CreateTime  ：2020/5/27.
 */
public class RNAllPayModule extends ReactContextBaseJavaModule {
    private static final  String MODULE_NAME = "AllPay";
    public static final String ACTION_ALLPAY_PAYMENT_RESPONSE = "com.heytea.ALLPAY_PAYMENT_RESPONSE";
    private final String TAG = "RNAllPayModule";
    private  Promise mPromise;
    private ReactContext mContext;

    public RNAllPayModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
        PaymentBroadCastReceiver receiver = new  PaymentBroadCastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_ALLPAY_PAYMENT_RESPONSE);
        this.mContext.registerReceiver(receiver, filter);
    }

    @NonNull
    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    private void allPay(final ReadableMap params, Promise promise) {
        this.mPromise = promise;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String tn = params.getString("tn");
                if (!TextUtils.isEmpty(tn)) {
                    Log.i(TAG, "tn=" + tn);
                    AllPayEngine.pay(getCurrentActivity(), tn, false);
                } else {
                   getCurrentActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(
                                    getCurrentActivity().getApplicationContext(), "获取tn失败:" + "1234567890",
                                    Toast.LENGTH_SHORT);
                            toast.show();

                        }
                    });
                }
            }
        }).start();

    }


    public class PaymentBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            String response = bundle.getString("response");
            if(mPromise != null) {
                mPromise.resolve(response);
            }
            Log.d(TAG,response);
        }
    }
}
