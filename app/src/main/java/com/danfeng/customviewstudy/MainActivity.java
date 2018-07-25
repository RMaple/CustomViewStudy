package com.danfeng.customviewstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button oneoneButton = findViewById(R.id.btn_one_one);
        oneoneButton.setOnClickListener(this);
        Button onetwoButton = findViewById(R.id.btn_one_two);
        onetwoButton.setOnClickListener(this);
        Button onethreeButton = findViewById(R.id.btn_one_three);
        onethreeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one_one:
                startActivity(ContentActivity.newIntent(MainActivity.this, "Hencoder 1-1"));
                break;
            case R.id.btn_one_two:
                startActivity(ContentActivity.newIntent(MainActivity.this, "Hencoder 1-2"));
                break;
            case R.id.btn_one_three:
                startActivity(ContentActivity.newIntent(MainActivity.this, "Hencoder 1-3"));
                break;
        }
    }
}
