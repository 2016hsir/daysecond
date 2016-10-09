package com.example.hxf.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by rz on 2016/9/4.
 */
public class MyAdapter extends FragmentPagerAdapter {
    List<Fragment> list_Fragment;
    List<String> list_Title;

    public MyAdapter(FragmentManager fm, List<Fragment> list_Fragment, List<String> list_Title) {
        super(fm);
        this.list_Fragment = list_Fragment;
        this.list_Title = list_Title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_Fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_Fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position%list_Title.size());
    }
}
