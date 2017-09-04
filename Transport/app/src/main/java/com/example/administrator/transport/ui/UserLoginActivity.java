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
import com.example.administrator.transport.bean.User;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


public class UserLoginActivity extends Activity {

    EditText et_username;
    EditText et_userpwd;
    ArrayList<User> UserList = new ArrayList<User>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin);
        et_username = (EditText) findViewById(R.id.et_username);
        et_userpwd = (EditText) findViewById(R.id.et_userpwd);
        Button bt_userLogin = (Button) findViewById(R.id.bt_userLogin);


        bt_userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = et_username.getText().toString().trim();
                final String password = et_userpwd.getText().toString().trim();

                if (name.equals("")) {
                    toast("填写你的手机号");
                    return;
                }
                if (password.equals("")) {
                    toast("填写你的密码");
                    return;
                }

                if (name.length() <= 0 && password.length() <= 0) {

                    Toast.makeText(UserLoginActivity.this, "用户名或密码为空", 0).show();
                } else if (name.length() <= 0) {
                    Toast.makeText(UserLoginActivity.this, "用户名不能为空", 0).show();
                } else if (password.length() <= 0) {
                    Toast.makeText(UserLoginActivity.this, "密码不能为空", 0).show();
                } else if (name != null && password != null) {

                    // 获取存储的数据
                    BmobQuery<User> query = new BmobQuery<User>();

                    query.findObjects(new FindListener<User>() {
                        @Override
                        public void done(List<User> list, BmobException e) {
                            for (User d : list) {
                                String savename = d.getUsername();
                                String savepwd = d.getUserpwd();
                                //判断用户名与密码是否和保存的数据一致，进行提醒或者登录
                                if (name.equals(savename) && password.equals(savepwd)) {
                                    Intent intent = new Intent(getApplicationContext(), UserMainActivity.class);
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
        Toast.makeText(UserLoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}