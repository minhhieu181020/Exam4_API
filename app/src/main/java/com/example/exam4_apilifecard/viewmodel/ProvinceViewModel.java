package com.example.exam4_apilifecard.viewmodel;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.exam4_apilifecard.adapter.ProvinceAdapter;
import com.example.exam4_apilifecard.databinding.CustomViewBinding;
import com.example.exam4_apilifecard.model.ListArea;
import com.example.exam4_apilifecard.model.ProvinceModel;
import com.example.exam4_apilifecard.request.RequestApiUntils;
import com.example.exam4_apilifecard.request.RequestBase64;
import com.example.exam4_apilifecard.response.ResponseBase64;
import com.example.exam4_apilifecard.service.MyRetrofit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProvinceViewModel extends BaseObservable {
    private Context context;
    private List<ListArea> listAreas;
    private ProvinceAdapter adapterRecycleViewTinh;
    private CustomViewBinding binding;


    public ProvinceViewModel(Context context, CustomViewBinding binding) {
        this.context = context;
        this.binding = binding;
        GetData();
    }

    public void GetData() {
        RequestBase64 requestBase64 = RequestApiUntils.createRequest("eyJhcmVhVHlwZSI6IlAiLCJwYXJlbnRDb2RlIjoiIn0=", context);
        Retrofit retrofit = MyRetrofit.getInstance("https://lifecardtest.viviet.vn/");
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getBase64(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                Log.e("abc", response.body().getBody());
                String decode = response.body().getBody();
                String decoded = new String(Base64.decode(decode, 1));
                Log.e("json", decoded);

                Gson gson = new Gson();

                ProvinceModel provinceModel = gson.fromJson(decoded, ProvinceModel.class);
                List<ListArea> listAreaList = provinceModel.getListArea();

                listAreas =new ArrayList<>();
                listAreas.addAll(listAreaList);
                Log.e("data", listAreas.size()+"");
                getList(listAreas);
            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {

            }
        });
    }
    private void getList(List arrayList) {
        binding.listprovince.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        binding.listprovince.setLayoutManager(staggeredGridLayoutManager);
        adapterRecycleViewTinh = new ProvinceAdapter(arrayList,context);
        binding.listprovince.setAdapter(adapterRecycleViewTinh);


    }
}
