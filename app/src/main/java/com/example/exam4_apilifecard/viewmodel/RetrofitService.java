package com.example.exam4_apilifecard.viewmodel;

import com.example.exam4_apilifecard.request.RequestBase64;
import com.example.exam4_apilifecard.response.ResponseBase64;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {


    @POST("lifecard-app/area/req")
    Call<ResponseBase64> getBase64(@Body RequestBase64 requestBase64);
}
