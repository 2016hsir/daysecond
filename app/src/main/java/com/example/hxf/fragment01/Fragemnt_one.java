package com.example.hxf.fragment01;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hxf.adapter.MyAdapter;
import com.example.hxf.androidproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-3.
 */
public class Fragemnt_one extends Fragment implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

   ViewPager viewPager;
   List<Fragment> data;
    List<String>  data_Title;
    TabLayout tabLayout;
    MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,null);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        adapter=new MyAdapter(getActivity().getSupportFragmentManager(),data,data_Title);
        viewPager.setAdapter(adapter);
       ;tabLayout.setOnTabSelectedListener(this);
        viewPager.setOnPageChangeListener(this);
    }

    private void initData() {
        data=new ArrayList<>();
        Fragment_one_1 fragment1=new Fragment_one_1();
        Fragment_one_2 fragment2=new Fragment_one_2();
        Fragment_one_3 fragment3=new Fragment_one_3();
        Fragment_one_4 fragment4=new Fragment_one_4();
        data.add(fragment1);
        data.add(fragment2);
        data.add(fragment3);
        data.add(fragment4);

       data_Title=new ArrayList<>();
        data_Title.add("精选");
        data_Title.add("器材");
        data_Title.add("影响");
        data_Title.add("学院");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(data_Title.get(0)).setTag(0));
        tabLayout.addTab(tabLayout.newTab().setText(data_Title.get(1)).setTag(1));
        tabLayout.addTab(tabLayout.newTab().setText(data_Title.get(2)).setTag(2));
        tabLayout.addTab(tabLayout.newTab().setText(data_Title.get(3)).setTag(3));
    }

    private void initView() {
        viewPager= (ViewPager) getView().findViewById(R.id.viewpagerId);
        tabLayout= (TabLayout) getView().findViewById(R.id.tabId);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem((Integer) tab.getTag());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabLayout.setScrollPosition(position,0,true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
