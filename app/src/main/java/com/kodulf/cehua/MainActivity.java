package com.kodulf.cehua;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
//public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private ViewPager viewPager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        menu = (NavigationView) findViewById(R.id.main_menu);
//        menu = (LinearLayout) findViewById(R.id.menu);
//        menu.setOnClickListener(this);
//        显示Home
        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        //三条横线的Menu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
        drawer.setDrawerListener(toggle);//让DrawerLayout的动作影响上面的按钮
        menu.setNavigationItemSelectedListener(this);
        viewPager = (ViewPager) findViewById(R.id.pager);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
           list.add(String.valueOf(i));
        }
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab = (TabLayout)findViewById(R.id.tablayout);
        tab.setupWithViewPager(viewPager);
    }

    /**
     * menu点击后DrawerLayout 变化
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //return false;
        switch (item.getItemId()){
            case R.id.item_1:
                Toast.makeText(this,"first",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_4:
                ActivityCompat.finishAffinity(this);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public void onClick(View v) {
//        //drawer.closeDrawer(menu);
//        //drawer.closeDrawer(Gravity.START);//4.0一下是不能使用START的
//        drawer.closeDrawer(GravityCompat.START);//这样就可以了
//    }

}
