package com.example.administrator.transport.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.transport.R;
import com.example.administrator.transport.bean.Userr;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class UserSecondActivity extends Activity{
    private String context;
    EditText et_c;
    EditText et_g;
    EditText et_b;
    EditText et_d;


    private Button bt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        setContentView(R.layout.user_secondfragment);
        et_c = (EditText) findViewById(R.id.et_ctype);
        et_g = (EditText) findViewById(R.id.et_gtype);
        et_b = (EditText) findViewById(R.id.et_birthland);
        et_d = (EditText) findViewById(R.id.et_destination);

        bt = (Button) findViewById(R.id.button6);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = et_c.getText().toString().trim();
                String b = et_g.getText().toString().trim();
                String f = et_b.getText().toString().trim();
                String g = et_d.getText().toString().trim();
                Userr u = new Userr();
                u.setCtype(a);
                u.setGtype(b);
                u.setBirthland(f);
                u.setDestination(g);
                u.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            toast("发布订单成功");

                        }else{
                            toast("发布失败");
                        }
                    }
                });
            }

        });

    }

    private void toast(String s) {
        Toast.makeText(UserSecondActivity.this,s,Toast.LENGTH_SHORT).show();
    }
 

}
