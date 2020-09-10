package com.example.exam4_apilifecard.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.exam4_apilifecard.R;
import com.example.exam4_apilifecard.databinding.CustomViewBinding;
import com.example.exam4_apilifecard.viewmodel.ProvinceViewModel;

public class CustomView extends LinearLayout {

    public CustomView(Context context) {
        super(context);

        CustomViewBinding   binding = DataBindingUtil.setContentView((Activity) context, R.layout.custom_view);
        binding.setProvinceViewModel(new ProvinceViewModel((Activity) context,binding));
        binding.executePendingBindings();


    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
