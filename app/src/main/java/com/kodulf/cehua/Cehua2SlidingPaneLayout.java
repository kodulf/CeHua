package com.kodulf.cehua;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class Cehua2SlidingPaneLayout extends AppCompatActivity implements View.OnClickListener, SlidingPaneLayout.PanelSlideListener {

    private View content;
    private SlidingPaneLayout sliding;
    private View menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cehua2_sliding_pane_layout);
        sliding = (SlidingPaneLayout) findViewById(R.id.sliding);
        content = findViewById(R.id.framelayout);
        sliding.setPanelSlideListener(this);

        menu = findViewById(R.id.menu);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        //slideOffset全部打开是1，完全关闭时0

        //缩放的锚点，是左侧的中心点,默认的锚点坐标是在中心点上面，那么我们改变X就行了。
        content.setPivotX(0);

        //获取屏幕宽度的一半是不可以的
//        WindowManager manager = getWindowManager();
//        Display defaultDisplay = manager.getDefaultDisplay();
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        defaultDisplay.getMetrics(outMetrics);
//        int heightPixels = outMetrics.heightPixels;
//        content.setPivotY(heightPixels / 2);
        //获取控件的宽度的一半就可以了
        int height = panel.getHeight();
        content.setPivotY(height / 2);


        content.setScaleX(1 - slideOffset * 0.5f);
        content.setScaleY(1 - slideOffset * 0.5f);

        //如果要兼容2.0的手机
//        ViewCompat.setPivotX(content, 0);
//        ViewCompat.setPivotX(content, height / 2);
//        ViewCompat.setScaleX(content, 1 - slideOffset * 0.5f);
//        ViewCompat.setScaleY(content, 1 - slideOffset * 0.5f);

//        ViewCompat.setTranslationX(menu,-menu.getWidth()/2*(1-slideOffset));
    }

    @Override
    public void onPanelOpened(View panel) {

    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
