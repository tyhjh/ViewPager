package com.yorhp.viewpager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import adapter.SimpleBannerAdapter;
import myview.CyclePagerAdapter;
import myview.CycleViewPager;
import myview.ViewPagerIndicator;

public class MainActivity extends AppCompatActivity {

    CycleViewPager vp_home;
    CyclePagerAdapter adapter;
    ViewPagerIndicator mIndicator;
    ArrayList<String> aray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.indicator2);
        vp_home = (CycleViewPager) findViewById(R.id.vp_home);
        initData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    aray.add("http://ac-fgtnb2h8.clouddn.com/4381a95edb903f88f0bf.jpg");
                    aray.add("http://ac-fgtnb2h8.clouddn.com/39dbac52c49bf3a535cb.jpg");
                    aray.add("http://ac-fgtnb2h8.clouddn.com/0a6fa1ede06bddc9c3f0.jpg");
                    aray.add("http://ac-fgtnb2h8.clouddn.com/97bd227bf380ad3be0fe.jpg");
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initViewPaper() {
        adapter=new SimpleBannerAdapter(this,aray);
        vp_home.setAdapter(adapter);
        mIndicator.bindToViewPager(vp_home);
    }

    @Override
    protected void onStart() {
        super.onStart();
        vp_home.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        vp_home.stopAutoScroll();
    }


    private void initData() {
        aray.add("http://ac-fgtnb2h8.clouddn.com/aa71168e31ee92ddeed5.jpg");
        aray.add("http://ac-fgtnb2h8.clouddn.com/8ec533ffdb1f04844653.jpg");
        aray.add("http://ac-fgtnb2h8.clouddn.com/77350ef53cc72b24c9a8.jpg");
        aray.add("http://ac-fgtnb2h8.clouddn.com/20c855dc058b48a0cf90.jpg");
        initViewPaper();
    }


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            initViewPaper();
        }
    };

}
