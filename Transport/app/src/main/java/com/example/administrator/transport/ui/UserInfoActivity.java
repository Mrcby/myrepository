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
import com.example.administrator.transport.bean.UserInfo;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.example.administrator.transport.R.id.info10;
import static com.example.administrator.transport.R.id.info11;
import static com.example.administrator.transport.R.id.info8;
import static com.example.administrator.transport.R.id.info9;


public class UserInfoActivity extends Activity {
    EditText et_name;
    EditText et_gender;
    EditText et_age;
    EditText et_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);

        et_name = (EditText) findViewById(info8);
        et_gender = (EditText) findViewById(info9);
        et_age = (EditText) findViewById(info10);
        et_data = (EditText) findViewById(info11);
        Button bt_save = (Button) findViewById(R.id.button7);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString().trim();
                String gender = et_gender.getText().toString().trim();
                String age = et_age.getText().toString().trim();
                String data = et_data.getText().toString().trim();
                if (name.equals("")) {
                    toast("填写你的名字");
                    return;
                }
                if (age.equals("")) {
                    toast("填写你的年龄");
                    return;
                }
                if (gender.equals("")) {
                    toast("填写你的性别");
                    return;
                }
                if(data.equals("")) {
                    toast("填写你的出生日期");
                    return;
                }
                Intent a = new Intent(getApplicationContext(),UserInfoActivity.class);
                startActivity(a);
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String a = et_name.getText().toString().trim();
                int b = Integer.parseInt(et_age.getText().toString().trim());
                String c = et_gender.getText().toString().trim();
                String d = et_data.getText().toString().trim();
                UserInfo u = new UserInfo();
                u.setName(a);
                u.setAge(b);
                u.setGender(c);
                u.setDate(d);
                u.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            toast("保存成功");
                        }else{
                            toast("保存失败");
                        }
                    }
                });
            }


        });

    }

    private void toast(String msg) {
        Toast.makeText(UserInfoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}