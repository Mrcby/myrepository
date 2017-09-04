package com.example.administrator.transport.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.transport.R;
import com.example.administrator.transport.bean.Driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class DriverRegisterActivity extends Activity{
    EditText et_drivername;
    EditText et_driverpwd;
    EditText et_confirmmpwd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverregister);
        et_drivername = (EditText) findViewById(R.id.et_drivername);
        et_driverpwd = (EditText) findViewById(R.id.et_driverpwd);
        et_confirmmpwd = (EditText) findViewById(R.id.et_confirmmpwd);
        Button bt_driverRegistere = (Button) findViewById(R.id.bt_driverRegistere);

        bt_driverRegistere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String drivername = et_drivername.getText().toString().trim();
                String driverpwd = et_driverpwd.getText().toString().trim();
                String confirmmpwd = et_confirmmpwd.getText().toString().trim();
                if (drivername.equals("")) {
                    toast("填写你的手机名");
                    return;
                }
                if (driverpwd.equals("")) {
                    toast("填写你的密码");
                    return;
                }
                if (confirmmpwd.equals("")) {
                    toast("填写你的确认密码");
                    return;
                }
                if(!driverpwd.equals(confirmmpwd)){
                    toast("两次输入的密码不一致");
                    return;
                }
                if(checkPhoneNumber(drivername)) {
                    Driver d = new Driver();
                    d.setDrivername(drivername);
                    d.setDriverpwd(driverpwd);
                    d.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                toast("注册成功");
                                Intent a = new Intent(DriverRegisterActivity.this, DriverLoginActivity.class);
                                startActivity(a);

                            } else {
                                toast("注册失败");
                            }
                        }
                    });
                }
            }
        });

    }

    private void toast(String msg) {
        Toast.makeText(DriverRegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    public static boolean checkPhoneNumber(String paramString) {
        String value = paramString;
        String regExp = "^13[0-9]{1}[0-9]{8}$|15[0125689]{1}[0-9]{8}$|18[0-9,5-9]{1}[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.matches();
    }
}
