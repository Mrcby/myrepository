package com.example.administrator.transport.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.administrator.transport.R;


public class LoginSelectorActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginselector);
        Button bt_userLogin = (Button) findViewById(R.id.bt_userLogin);
        bt_userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),UserLoginActivity.class);
                startActivity(a);
            }
        });
        Button bt_driverLogin = (Button) findViewById(R.id.bt_driverLogin);
        bt_driverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),DriverLoginActivity.class);
                startActivity(b);
            }
        });
    }
}
