package com.example.exam4_apilifecard.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.exam4_apilifecard.R;
import com.example.exam4_apilifecard.databinding.CustomViewBinding;
import com.example.exam4_apilifecard.request.RequestApiUntils;
import com.example.exam4_apilifecard.request.RequestBase64;
import com.example.exam4_apilifecard.response.ResponseBase64;
import com.example.exam4_apilifecard.service.MyRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CustomView extends LinearLayout {

    CustomViewBinding binding;
    static Context context;
    public CustomView(Context context) {
        super(context);
        this.context = context;

        binding = DataBindingUtil.setContentView((Activity) context, R.layout.custom_view);
        binding.setDistric(new DistricViewModel());
        GetData();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void GetData(){
        RequestBase64 requestBase64 = RequestApiUntils.createRequest("eyJhcmVhVHlwZSI6IlAiLCJwYXJlbnRDb2RlIjoiIn0=", context);
        Retrofit retrofit = MyRetrofit.getInstance("https://lifecardtest.viviet.vn/");
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getBase64(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                Log.e("abc",response.body().getBody());
                String decode = response.body().getBody();
                String decoded = new String(Base64.decode(decode,1));
                Log.e("json", decoded);
            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {

            }
        });
    }
}
