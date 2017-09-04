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

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


@SuppressWarnings("WrongConstant")
public class DriverLoginActivity extends Activity {
    EditText et_drivername;
    EditText et_driverpwd;
    ArrayList<Driver> DriverList = new ArrayList<Driver>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverlogin);
        et_drivername = (EditText) findViewById(R.id.et_drivername);
        et_driverpwd = (EditText) findViewById(R.id.et_driverpwd);
        Button bt_driverLogin = (Button) findViewById(R.id.bt_driverLogin);

        bt_driverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = et_drivername.getText().toString().trim();
                final String password = et_driverpwd.getText().toString().trim();

                if (name.equals("")) {
                    toast("填写你的用户名");
                    return;
                }
                if (password.equals("")) {
                    toast("填写你的密码");
                    return;
                }

                if (name.length() <= 0 && password.length() <= 0) {
                    toast("用户名或密码为空");
                } else if (name.length() <= 0) {
                   toast("用户名不能为空");
                } else if (password.length() <= 0) {
                    toast("密码不能为空");
                } else if (name != null && password != null) {

                    // 获取存储的数据
                    BmobQuery<Driver> query = new BmobQuery<Driver>();

                    query.findObjects(new FindListener<Driver>() {
                        @Override
                        public void done(List<Driver> list, BmobException e) {
                            for (Driver d : list) {
                                String savename = d.getDrivername();
                                String savepwd = d.getDriverpwd();
                                //判断用户名与密码是否和保存的数据一致，进行提醒或者登录
                                if (name.equals(savename) && password.equals(savepwd)) {
                                    Intent intent = new Intent(getApplicationContext(), DriverMainActivity.class);
                                    startActivity(intent);
                                    finish();
                                    break;
                                } else {
                                    toast("用户名或密码错误");
                                }
                            }
                        }
                    });

                }
            }
        });

    }

    private void toast(String msg) {
        Toast.makeText(DriverLoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}



