package com.mvvm.javademo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *
 * @author rainy.liao
 * @date 2018/8/30
 */

public class Utils {

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectionManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectionManager!=null){
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo !=null){
                return networkInfo.isConnected();
            }
        }
        return false;
    }

}
