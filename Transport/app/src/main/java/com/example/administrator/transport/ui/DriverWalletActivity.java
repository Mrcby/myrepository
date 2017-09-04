package com.example.administrator.transport.ui;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.transport.R;
import com.example.administrator.transport.bean.DriverBalance;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class DriverWalletActivity extends Activity{
    private Button bt;
    private Button bt2;
    EditText a;
    EditText price;
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverwallet);
        a = (EditText) findViewById(R.id.txt6);
        String b = a.getText().toString();
        final Double c = Double.parseDouble(b);

        bt = (Button) findViewById(R.id.button16);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DriverWalletActivity.this);
                builder.setTitle("请输入充值金额：");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                price = new EditText(DriverWalletActivity.this);
                builder.setView(price);
                builder.setPositiveButton("确定",
                        new android.content.DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int which) {
                                DriverBalance z = new DriverBalance();
                                String d = price.getText().toString().trim();
                                Double e = Double.parseDouble(d);
                                final Double f = c+e;
                                z.setUb(e);
                                z.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if(e==null){
                                            a.setText(f.toString());
                                            toast("充值成功");
                                        }else{
                                            toast("充值失败");
                                        }
                                    }
                                });
                            }
                        });
                builder.setNegativeButton("取消", null);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        bt2 = (Button) findViewById(R.id.button17);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DriverWalletActivity.this);
                builder.setTitle("请输入提现金额：");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                price = new EditText(DriverWalletActivity.this);
                builder.setView(price);
                builder.setPositiveButton("确定",
                        new android.content.DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int which) {
                                String d = price.getText().toString().trim();
                                if(d!=null){
                                    toast("提现成功");
                                }else{
                                    toast("提现失败");
                                }
                            }
                        });
                builder.setNegativeButton("取消", null);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }
    private void toast(String s) {
        Toast.makeText(DriverWalletActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
