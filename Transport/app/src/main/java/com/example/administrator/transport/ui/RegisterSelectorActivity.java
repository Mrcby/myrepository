package com.example.administrator.transport.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.administrator.transport.R;


public class RegisterSelectorActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerselector);
        Button bt_userRegister= (Button) findViewById(R.id.bt_userRegister);
        bt_userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),UserRegisterActivity.class);
                startActivity(a);

            }
        });
        Button bt_driverRegister= (Button) findViewById(R.id.bt_driverRegister);
        bt_driverRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),DriverRegisterActivity.class);
                startActivity(a);

            }
        });
    }
}
