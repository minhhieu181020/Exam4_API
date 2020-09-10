package com.example.exam4_apilifecard.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.exam4_apilifecard.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomView customView=new CustomView(this);

    }
}