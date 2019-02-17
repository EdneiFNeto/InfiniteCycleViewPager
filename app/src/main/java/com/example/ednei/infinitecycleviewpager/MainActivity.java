package com.example.ednei.infinitecycleviewpager;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.example.ednei.infinitecycleviewpager.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> list;
    private HorizontalInfiniteCycleViewPager infiniteCycleViewPager;
    private boolean isPressedLeft, isPressedRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        infiniteCycleViewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.infinity);
        infiniteCycleViewPager.setAdapter(new MyAdapter(this));
        infiniteCycleViewPager.setScrollDuration(600);
        infiniteCycleViewPager.setSaveEnabled(true);

        infiniteCycleViewPager.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch (event.getAction()) {
                    case 1:
                        infiniteCycleViewPager.notifyDataSetChanged();

                        switch (event.getKeyCode()) {
                            case 22:
                                isPressedLeft = true;
                                break;

                            case 21:
                                isPressedLeft = false;
                                break;
                        }

                        move();
                        break;

                    case 0:
                        infiniteCycleViewPager.notifyDataSetChanged();
                        break;
                }

                return false;
            }
        });
    }

    private void move() {

        if (isPressedLeft) {
            infiniteCycleViewPager.startAutoScroll(false);
        } else {
            infiniteCycleViewPager.startAutoScroll(true);
        }

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                infiniteCycleViewPager.stopAutoScroll();
            }
        });
    }
}
