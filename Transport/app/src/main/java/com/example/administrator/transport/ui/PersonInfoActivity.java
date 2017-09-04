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
import com.example.administrator.transport.bean.DriverInfo;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.example.administrator.transport.R.id.info1;
import static com.example.administrator.transport.R.id.info15;
import static com.example.administrator.transport.R.id.info2;
import static com.example.administrator.transport.R.id.info3;
import static com.example.administrator.transport.R.id.info4;
import static com.example.administrator.transport.R.id.info5;



public class PersonInfoActivity extends Activity {
    EditText et_name;
    EditText et_gender;
    EditText et_age;
    EditText et_data;
    EditText et_cartype;
    EditText et_number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverpersoninfo);

        et_name = (EditText) findViewById(info1);
        et_gender = (EditText) findViewById(info2);
        et_age = (EditText) findViewById(info3);
        et_data = (EditText) findViewById(info4);
        et_cartype = (EditText) findViewById(info15);
        et_number = (EditText) findViewById(info5);
        Button bt_save = (Button) findViewById(R.id.info6);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString().trim();
                String gender = et_gender.getText().toString().trim();
                String age = et_age.getText().toString().trim();
                String data = et_data.getText().toString().trim();
                String cartype = et_cartype.getText().toString().trim();
                String number = et_number.getText().toString().trim();
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
                if(data.equals("")){
                    toast("填写你的出生日期");
                    return;
                }
                if(cartype.equals("")){
                    toast("填写你的车辆类型");
                    return;
                }
                if(number.equals("")){
                    toast("填写你的驾驶证号");
                    return;
                }


                Intent a = new Intent(getApplicationContext(),PersonInfoActivity.class);
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
                String g = et_cartype.getText().toString().trim();
                String f = et_number.getText().toString().trim();
                DriverInfo u = new DriverInfo();
                u.setName(a);
                u.setAge(b);
                u.setGender(c);
                u.setDate(d);
                u.setCtype(g);
                u.setCnumber(f);
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
        Toast.makeText(PersonInfoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
