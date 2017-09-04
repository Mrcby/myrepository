package com.example.administrator.transport.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.transport.R;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //默认初始化bomb
        Bmob.initialize(this, "5f90ff2bb8d23aa4f47087265112b95f");
        Bmob.initialize(this, "5f90ff2bb8d23aa4f47087265112b95f","bmob");

        setContentView(R.layout.main);
        Button bt_register = (Button) findViewById(R.id.bt_register);
        Button bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),LoginSelectorActivity.class);
                startActivity(a);
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),RegisterSelectorActivity.class);
                startActivity(a);
            }
        });
    }
}
