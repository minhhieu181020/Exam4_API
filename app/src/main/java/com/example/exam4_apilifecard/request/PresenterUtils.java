package com.example.exam4_apilifecard.request;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

public class PresenterUtils {

    private static SharedPreferences spRequestId;
    private static SharedPreferences.Editor editSP_requestId;
    public static long getClientRequestId(Context context) {
        spRequestId = context.getSharedPreferences("clientReqCount",
                Context.MODE_PRIVATE);
        editSP_requestId = spRequestId.edit();
        Date d = new Date();
        long t = d.getTime() % (8640 * 1000 * 30);
        return (t + getClientRequestCount(9999) + (long) (Math.random() * 1000));
    }

    private static long getClientRequestCount(int max) {
        long c = 0;
        try {
            c = spRequestId.getLong("clientReqCount", 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
        c %= max;
        editSP_requestId.putLong("clientReqCount", (c++));
        editSP_requestId.commit();
        return c;
    }
}
