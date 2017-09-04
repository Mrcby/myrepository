package com.example.administrator.transport.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.transport.R;
import com.example.administrator.transport.bean.Price;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class UserFindPriceActivity extends Activity{
    private TextView mTextView;
    private TextView mTextView2;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userfindprice);
        mTextView = (TextView) findViewById(R.id.info20);
        mTextView2 = (TextView) findViewById(R.id.info21);
        mTextView.setClickable(true);
        mTextView2.setClickable(true);
        BmobQuery<Price> query = new BmobQuery<Price>();
        Price p = new Price();
        query.findObjects(new FindListener<Price>() {
            @Override
            public void done(List<Price> list, BmobException e) {
                String a = " ";
                if(e==null){
                    for(Price pr:list){
                       a = pr.getPrice()+","+a;
                    }
                    toast("查询到"+list.size()+"条报价！");
                    String[] c = a.split(",");
                    mTextView.setText(c[0]);
                    mTextView2.setText(c[1]);
                    mTextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder=new AlertDialog.Builder(UserFindPriceActivity.this);
                            builder.setTitle("确认订支付订单");
                            builder.setIcon(android.R.drawable.ic_dialog_info);

                            builder.setPositiveButton("确定",
                                    new android.content.DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int which) {
                                            toast("支付成功");

                                        }
                                    });
                            builder.setNegativeButton("取消", null);
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                    });
                    mTextView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder=new AlertDialog.Builder(UserFindPriceActivity.this);
                            builder.setTitle("确认支付订单：");
                            builder.setIcon(android.R.drawable.ic_dialog_info);

                            builder.setPositiveButton("确定",
                                    new android.content.DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int which) {
                                            toast("支付成功");
                                        }
                                    });
                            builder.setNegativeButton("取消", null);
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                    });

                }else{
                    toast("查询失败");
                }
            }
        });
    }
    private void toast(String s) {
        Toast.makeText(UserFindPriceActivity.this, s, Toast.LENGTH_SHORT).show();
    }

}
