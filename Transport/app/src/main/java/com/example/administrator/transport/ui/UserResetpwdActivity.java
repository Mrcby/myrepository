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

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class UserResetpwdActivity extends Activity {
    EditText et_oldPwd2;
    EditText et_newPwd2;
    EditText et_confirmpwd3;
    Button bt_alter2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userresetpwd);
        et_oldPwd2= (EditText) findViewById(R.id.et_oldPwd2);
        et_newPwd2= (EditText) findViewById(R.id.et_newPwd2);
        et_confirmpwd3= (EditText) findViewById(R.id.et_confirmpwd3);
        bt_alter2 = (Button) findViewById(R.id.bt_alter2);
        bt_alter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String oldPwd = et_oldPwd2.getText().toString().trim();
                final String newPwd = et_newPwd2.getText().toString().trim();
                String confirmpwd = et_confirmpwd3.getText().toString().trim();

                BmobQuery<User> query = new BmobQuery<User>();

                query.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                        if (e == null) {
                            for (User u : list) {
                                if (oldPwd.equals(u.getUserpwd())) {
                                    u.setUserpwd(newPwd);
                                    u.update(u.getObjectId(), new UpdateListener() {
                                        @Override
                                        public void done(BmobException e) {
                                            if(e==null){
                                                toast("修改成功");
                                                Intent intent = new Intent(getApplicationContext(), UserLoginActivity.class);
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
                Toast.makeText(UserResetpwdActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
