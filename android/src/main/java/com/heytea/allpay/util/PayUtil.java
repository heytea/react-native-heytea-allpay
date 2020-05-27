package com.heytea.allpay.util;

import android.util.Log;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bensonzhang on 2017/12/12.
 */

public class PayUtil {



    public static String getSign(Map<String,String> params,String key,String signType) {
        Map<String, String> resultMap = sortMapByKey(params);  //按Key进行排序
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            sb.append('&');
        }
        sb.deleteCharAt(sb.lastIndexOf("&"));
        sb.append(key);
        Log.i("opp",sb.toString());
        String sign =EncoderUtil.Encrypt(sb.toString(), signType) ;
        Log.i("opp",sign);
        return sign;
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }


  static   class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
    }


}
