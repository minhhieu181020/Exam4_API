package com.example.exam4_apilifecard.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.exam4_apilifecard.R;
import com.example.exam4_apilifecard.databinding.DistricCustomViewBinding;
import com.example.exam4_apilifecard.databinding.WardsCustomViewBinding;
import com.example.exam4_apilifecard.viewmodel.DistricViewModel;
import com.example.exam4_apilifecard.viewmodel.WardsViewModel;

public class WardsCustomView extends LinearLayout {
    public WardsCustomView(Context context,String body, String codeDis) {
        super(context);
        WardsCustomViewBinding districCustomViewBinding = DataBindingUtil.setContentView((Activity) context, R.layout.wards_custom_view);
        districCustomViewBinding.setWards(new WardsViewModel((Activity) context,districCustomViewBinding ,body, codeDis));
        districCustomViewBinding.executePendingBindings();
    }

    public WardsCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WardsCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
