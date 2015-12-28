package com.kodulf.cehua;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.kodulf.cehua.fragments.BlankFragment2;

import java.util.List;

/**
 * Created by Administrator on 15-12-28.
 */
public class MyAdapter extends FragmentPagerAdapter {

    private List<String> list;

    public MyAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("151228MY", "postion" + position);
        return BlankFragment2.newInstance(list.get(position));
        //return null;
    }

    @Override
    public int getCount() {
//        return 0;
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return list.get(position);
    }
}
