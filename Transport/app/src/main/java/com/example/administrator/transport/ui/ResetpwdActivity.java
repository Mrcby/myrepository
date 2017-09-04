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

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;


public class ResetpwdActivity extends Activity {
    EditText et_oldPwd;
    EditText et_newPwd;
    EditText et_confirmpwd;
    Button bt_alter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpwd);
        et_oldPwd= (EditText) findViewById(R.id.et_oldPwd);
        et_newPwd= (EditText) findViewById(R.id.et_newPwd);
        et_confirmpwd= (EditText) findViewById(R.id.et_confirmpwd2);
        bt_alter = (Button) findViewById(R.id.bt_alter);
        bt_alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String oldPwd = et_oldPwd.getText().toString().trim();
                final String newPwd = et_newPwd.getText().toString().trim();
                String confirmpwd = et_confirmpwd.getText().toString().trim();

                BmobQuery<Driver> query = new BmobQuery<Driver>();

                query.findObjects(new FindListener<Driver>() {
                    @Override
                    public void done(List<Driver> list, BmobException e) {
                        if (e == null) {
                            for (Driver d : list) {
                                if (oldPwd.equals(d.getDriverpwd())) {
                                    d.setDriverpwd(newPwd);
                                    d.update(d.getObjectId(), new UpdateListener() {
                                        @Override
                                        public void done(BmobException e) {
                                            if(e==null){
                                                toast("修改成功");
                                                Intent intent = new Intent(getApplicationContext(), DriverLoginActivity.class);
                                                startActivity(intent);
                                            }else{
                                                toast("修改失败");
                                            }
                                        }
                                    });

                                }
                            }
                        } else {
                            toast("修改失败");
                        }
                    }

                });

            }

            private void toast(String msg) {
                Toast.makeText(ResetpwdActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
