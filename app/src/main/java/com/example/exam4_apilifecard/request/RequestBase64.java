
package com.example.exam4_apilifecard.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBase64 {

    @SerializedName("restHeader")
    @Expose
    private RestHeader restHeader;
    @SerializedName("body")
    @Expose
    private String body;

    public RestHeader getRestHeader() {
        return restHeader;
    }

    public void setRestHeader(RestHeader restHeader) {
        this.restHeader = restHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
