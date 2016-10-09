package com.example.hxf.androidproject;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.hxf.activity.StartActivity;
import com.example.hxf.fragment01.Fragemnt_one;
import com.example.hxf.fragment04.Fragment_four;
import com.example.hxf.fragment03.Fragment_three;
import com.example.hxf.fragment02.Fragment_two;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;
    List<Fragment> datas;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this, StartActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.relative,datas.get(0)).commit();

    }


    private void initData() {
        datas=new ArrayList<>();
        Fragemnt_one fragment1=new Fragemnt_one();
        datas.add(fragment1);
       Fragment_two fragment2=new Fragment_two();
        datas.add(fragment2);
        Fragment_three  fragment3=new Fragment_three();
        datas.add(fragment3);
        Fragment_four fragment4=new Fragment_four();
        datas.add(fragment4);
    }

    private void initView() {
        radioGroup= (RadioGroup) findViewById(R.id.groupId);
        radioGroup.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = fragmentManager.beginTransaction();
        switch (checkedId){
            case  R.id.button1Id:
                transaction.replace(R.id.relative,datas.get(0));
                break;
            case  R.id.button2Id:
                transaction.replace(R.id.relative,datas.get(1));
                break;
            case  R.id.button3Id:
                transaction.replace(R.id.relative,datas.get(2));
                break;
            case  R.id.button4Id:
                transaction.replace(R.id.relative,datas.get(3));
                break;
            default:
                break;
        }
        transaction.commit();
    }


}
