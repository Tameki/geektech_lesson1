package com.geektech.navlesson.util;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.geektech.navlesson.fragments.SectionCalculatorFragment;
import com.geektech.navlesson.fragments.SectionEmptyFragment;
import com.geektech.navlesson.fragments.SectionFragment;

// Created by askar on 10/2/18.
//TODO: Создайте свой адаптер на основе этого для использования своих фрагментов
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private int mPagesCount = 3;

    public void setmTabLayout(TabLayout mTabLayout) {
        this.mTabLayout = mTabLayout;
    }

    private TabLayout mTabLayout;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //Возвращаем нужный фрагмент по заданной позиции i, можно использовать уже готовый список фрагментов
    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        String text = mTabLayout.getTabAt(i).getText().toString();


        switch (i) {
            case 0 : fragment = SectionEmptyFragment.getInstance(text); break;
            case 1 : fragment = SectionCalculatorFragment.getInstance(text); break;
            case 2 : fragment =  SectionFragment.getInstance("1"); break;
            default : fragment =  SectionFragment.getInstance(text); break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mPagesCount;
    }
}
