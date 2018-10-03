package com.geektech.navlesson.bottomnavbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.geektech.navlesson.R;
import com.geektech.navlesson.util.SectionsPagerAdapter;

//TODO: Изучить при создании смешанной навигации, раньше не советую
public class BottomNavActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mAdapter;
    private BottomNavigationView mNavigationView;

    //Listener для отлова кликов по пунктам в BottomNavigationView
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        init();
    }

    //endregion

    //region Private

    private void init(){
        mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initViewPager();
    }

    private void initViewPager(){
        mAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);

        //Только для примера, так как у нашего ViewPager-a отключены свайпы
        //и страницы в нем переключаются только BottomNavView
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //Элементы в BottomNavigationView доступны по их id
                mNavigationView.setSelectedItemId(getNavigationItemId(i));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    //Тоже только пример, т.к. читать выше
    private int getNavigationItemId(int position){
        int id;

        switch (position){
            case 0:
                id = R.id.navigation_home;
                break;
            case 1:
                id = R.id.navigation_dashboard;
                break;
            case 2:
                id = R.id.navigation_notifications;
                break;
            default:
                id = R.id.navigation_home;
                break;
        }

        return id;
    }

    //endregion
}
