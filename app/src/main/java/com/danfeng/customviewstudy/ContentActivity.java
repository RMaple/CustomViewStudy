package com.danfeng.customviewstudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.danfeng.customviewstudy.hencoder1.Hencoder11Fragment;

/**
 * Created by D22400 on 2018/7/16.
 * Email:danfeng.qiu@ck-telecom.com
 * Describe:
 */

public class ContentActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "ContentActivity";

    private FragmentManager mFragmentManager;

    private String mFragmentNo = "";


    public static Intent newIntent(Context ac, String no) {
        Intent intent = new Intent(ac, ContentActivity.class);
        intent.putExtra(EXTRA_ID, no);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        mFragmentManager = getSupportFragmentManager();
        if (getIntent().getStringExtra(EXTRA_ID) != null) {
            mFragmentNo = getIntent().getStringExtra(EXTRA_ID);
        }
        showFragment();
    }

    private void showFragment() {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.fragment_content);
        if (fragment == null) {
            switch (mFragmentNo) {
                case "Hencoder 1-1":
                    fragment = new Hencoder11Fragment();
                    break;
            }
            if (fragment != null) {
                mFragmentManager.beginTransaction().add(R.id.fragment_content, fragment)
                        .commit();
            }
        }
    }


}
