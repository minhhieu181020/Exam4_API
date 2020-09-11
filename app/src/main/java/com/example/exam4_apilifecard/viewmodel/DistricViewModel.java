package com.example.exam4_apilifecard.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.exam4_apilifecard.adapter.DistricAdapter;
import com.example.exam4_apilifecard.adapter.ProvinceAdapter;
import com.example.exam4_apilifecard.databinding.CustomViewBinding;
import com.example.exam4_apilifecard.databinding.DistricCustomViewBinding;
import com.example.exam4_apilifecard.model.ListArea;
import com.example.exam4_apilifecard.model.ProvinceModel;
import com.example.exam4_apilifecard.request.RequestApiUntils;
import com.example.exam4_apilifecard.request.RequestBase64;
import com.example.exam4_apilifecard.response.ResponseBase64;
import com.example.exam4_apilifecard.service.MyRetrofit;
import com.example.exam4_apilifecard.view.DistricCustomView;
import com.example.exam4_apilifecard.view.WardsCustomView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DistricViewModel extends BaseObservable {
    private Context context;
    private List<ListArea> listAreas;
    private ProvinceAdapter adapterRecycleViewTinh;
    private DistricCustomViewBinding binding;


    public DistricViewModel(Context context, DistricCustomViewBinding binding,String body) {
        this.context = context;
        this.binding = binding;
        String json = "{\"areaType\":\"D\",\"parentCode\":\""+body+"\"}";
        String endcode=new String(Base64.encode(json.getBytes(),1));
        GetData(endcode);
    }

    //eyJhcmVhVHlwZSI6IkQiLCJwYXJlbnRDb2RlIjoiSERVIn0= huyen hai duong
    //eyJhcmVhVHlwZSI6IlAiLCJwYXJlbnRDb2RlIjoiIn0= tinh
    public void GetData(String body) {
        RequestBase64 requestBase64 = RequestApiUntils.createRequest(body.toString().trim(), context);
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

                listAreas = new ArrayList<>();
                listAreas.addAll(listAreaList);
                Log.e("data", listAreas.size() + "");
                getList(listAreas);
            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {

            }
        });
    }

    private void getList(List arrayList) {
        binding.listDistric.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        binding.listDistric.setLayoutManager(staggeredGridLayoutManager);
        adapterRecycleViewTinh = new ProvinceAdapter(arrayList, context);
        binding.listDistric.setAdapter(adapterRecycleViewTinh);
        ProvinceAdapter.ItemClickSupport.addTo(binding.listDistric).setOnItemClickListener(new ProvinceAdapter.ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                WardsCustomView districCustomView=new WardsCustomView((Activity) context,listAreas.get(position).getAreaCode());
            }
        });

    }
}
