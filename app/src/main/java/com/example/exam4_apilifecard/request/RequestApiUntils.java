package com.example.exam4_apilifecard.request;

import android.content.Context;
import android.util.Log;

public class RequestApiUntils {


    public static RequestBase64 createRequest(String body, Context context) {
        RequestBase64 requestBase64 = new RequestBase64();
        requestBase64.setBody(body);

        try {
            Header.setClientRequestId(String.valueOf(PresenterUtils.getClientRequestId(context)));

        }catch (Exception ignored){

        }
        requestBase64.setRestHeader(Header.getHeader());
        return requestBase64;
    }
}
