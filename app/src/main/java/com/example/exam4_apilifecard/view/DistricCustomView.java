package com.example.exam4_apilifecard.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;

import com.example.exam4_apilifecard.R;
import com.example.exam4_apilifecard.databinding.CustomViewBinding;
import com.example.exam4_apilifecard.databinding.DistricCustomViewBinding;
import com.example.exam4_apilifecard.viewmodel.DistricViewModel;
import com.example.exam4_apilifecard.viewmodel.ProvinceViewModel;

public class DistricCustomView extends LinearLayout {


    public DistricCustomView(Context context, String body) {
        super(context);
        DistricCustomViewBinding districCustomViewBinding = DataBindingUtil.setContentView((Activity) context, R.layout.distric_custom_view);
        districCustomViewBinding.setDistric(new DistricViewModel((Activity) context,districCustomViewBinding ,body));
        districCustomViewBinding.executePendingBindings();
    }

    public DistricCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DistricCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
