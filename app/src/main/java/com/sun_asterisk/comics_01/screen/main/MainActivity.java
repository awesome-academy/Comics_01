package com.sun_asterisk.comics_01.screen.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.screen.bookshelf.BookshelfFragment;
import com.sun_asterisk.comics_01.screen.category.CategoryFragment;
import com.sun_asterisk.comics_01.screen.home.HomeFragment;
import com.sun_asterisk.comics_01.screen.main.adapter.TabFragmentPagerAdapter;
import com.sun_asterisk.comics_01.screen.profile.ProfileFragment;
import com.sun_asterisk.comics_01.utils.TabNavigation;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener {
    private final int LIMIT_PAGE = 5;
    private BottomNavigationView mBottomNavigationView;
    private ViewPager mViewPager;
    private MenuItem mPrevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        init();
    }

    private void addEvents() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void addControls() {
        mBottomNavigationView = findViewById(R.id.bottomNavigation);
        mViewPager = findViewById(R.id.viewPagerMain);
    }

    private void init() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(CategoryFragment.newInstance());
        fragments.add(BookshelfFragment.newInstance());
        fragments.add(ProfileFragment.newInstance());
        TabFragmentPagerAdapter adapter =
                new TabFragmentPagerAdapter(getSupportFragmentManager(), fragments);

        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(LIMIT_PAGE);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigationHome:
                mViewPager.setCurrentItem(TabNavigation.HOME);
                return true;
            case R.id.navigationCategory:
                mViewPager.setCurrentItem(TabNavigation.CATEGORY);
                return true;
            case R.id.navigationBookshelf:
                mViewPager.setCurrentItem(TabNavigation.BOOKSHELF);
                return true;
            case R.id.navigationProfile:
                mViewPager.setCurrentItem(TabNavigation.PROFILE);
                return true;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int index, float v, int i1) {
    }

    @Override
    public void onPageSelected(int position) {
        if (mPrevMenuItem != null) {
            mPrevMenuItem.setChecked(false);
        } else {
            mBottomNavigationView.getMenu().getItem(0).setChecked(false);
        }
        mBottomNavigationView.getMenu().getItem(position).setChecked(true);
        mPrevMenuItem = mBottomNavigationView.getMenu().getItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int position) {
    }
}
