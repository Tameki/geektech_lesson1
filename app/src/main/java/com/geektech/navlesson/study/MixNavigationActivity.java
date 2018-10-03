package com.geektech.navlesson.study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.navlesson.R;

// Created by askar on 10/2/18.
//TODO: Класс для реализации смешанной навигации
public class MixNavigationActivity extends AppCompatActivity {

    //region Lifecycle

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_nav);
        init();
    }

    //endregion

    //region Private

    private void init(){

    }

    //endregion

}
