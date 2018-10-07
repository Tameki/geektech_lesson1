package com.geektech.navlesson;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.geektech.navlesson.util.SectionsPagerAdapter;

import java.util.Arrays;
import java.util.List;

//TODO: Первые задачи можно решать переписывая код здесь
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mAdapter;
    private TabLayout mTabLayout;

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();
    }

    //region Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                showToast("Settings");
                return true;
            case R.id.action_help:
                showToast("Help");
                return true;
            case R.id.action_exit:
                showToast("Exit");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //endregion

    //endregion

    //region Private

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void init(){
        mAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.main_viewpager);
        mTabLayout = findViewById(R.id.main_tab_layout);

        mViewPager.setAdapter(mAdapter);

        initTabLayout();

        mAdapter.setmTabLayout(mTabLayout);

        //Связываем ViewPager и TabLayout
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTabLayout(){
        //Добавляем табы
        mTabLayout.addTab(getTab("Home"));
        mTabLayout.addTab(getTab("Posts"));
        mTabLayout.addTab(getTab("Settings"));
    }

    private TabLayout.Tab getTab(String text){
        return mTabLayout.newTab().setText(text);
    }

    //endregion

}
