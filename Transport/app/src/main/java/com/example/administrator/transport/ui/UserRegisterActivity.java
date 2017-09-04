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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class UserRegisterActivity extends Activity{
    EditText et_username;
    EditText et_userpwd;
    EditText et_confirmpwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userregister);

        et_username = (EditText) findViewById(R.id.et_username);
        et_userpwd = (EditText) findViewById(R.id.et_userpwd);
        et_confirmpwd = (EditText) findViewById(R.id.et_confirmpwd);
        Button bt_userRegistere = (Button) findViewById(R.id.bt_userRegistere);



        bt_userRegistere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String userpwd = et_userpwd.getText().toString().trim();
                String confirmpwd = et_confirmpwd.getText().toString().trim();
                if (username.equals("")) {
                    toast("填写你的手机号");

                    return;
                }
                if (userpwd.equals("")) {
                    toast("填写你的密码");
                    return;
                }
                if (confirmpwd.equals("")) {
                    toast("填写你的确认密码");
                    return;
                }
                if(!userpwd.equals(confirmpwd)){
                    toast("两次输入的密码不一致");
                    return;
                }
                if(checkPhoneNumber(username)) {
                    User u = new User();
                    u.setUsername(username);
                    u.setUserpwd(userpwd);
                    u.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                toast("注册成功");
                                Intent a = new Intent(UserRegisterActivity.this, UserLoginActivity.class);
                                startActivity(a);

                            }
                        }
                    });
                }else {
                    toast("注册失败");
                }

            }
        });

    }

    private void toast(String msg) {
        Toast.makeText(UserRegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    public static boolean checkPhoneNumber(String paramString) {
        String value = paramString;
        String regExp = "^13[0-9]{1}[0-9]{8}$|15[0125689]{1}[0-9]{8}$|18[0-9,5-9]{1}[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.matches();
    }


}
