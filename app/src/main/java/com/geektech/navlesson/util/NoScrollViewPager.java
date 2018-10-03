package com.geektech.navlesson.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

// Created by askar on 10/2/18.
// Remove ViewPager swipe and transition animations

//TODO: Использовать совместно с BottomNavigationView
public class NoScrollViewPager extends ViewPager {
    private boolean mSwipeEnabled = false;
    private int mTransitionTime = 0;

    public NoScrollViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setScroller();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mSwipeEnabled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return mSwipeEnabled;
    }

    //Используя рефлексию заменяем стандартный скроллер своим
    private void setScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new MyScroller(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPagingEnabled(boolean enabled){
        this.mSwipeEnabled = enabled;
    }

    public class MyScroller extends Scroller {
        MyScroller(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mTransitionTime);
        }
    }
}
