package com.example.administrator.transport.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.transport.R;
import com.example.administrator.transport.bean.Price;
import com.example.administrator.transport.bean.Userr;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class DriverSecondActivity extends Activity {
    private TextView mTextView;
    private Button button1;
    EditText et_price;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driversecond);

        mTextView = (TextView) findViewById(R.id.txt1);

        BmobQuery<Userr> query = new BmobQuery<Userr>();

        query.findObjects(new FindListener<Userr>() {
            @Override
            public void done(List<Userr> list, BmobException e) {
                if(e==null){
                    toast("查找到"+list.size()+"条订单");
                    String a =" ";
                    for (Userr us : list) {
                        String s ="车辆类型为："+us.getCtype()+"\n"+
                                "货物类型为："+us.getGtype()+"\n"+
                                "出发地点为："+us.getBirthland()+"\n"+
                                "终点为："+us.getDestination();
                                a = s+"\n"+a;
                    }
                    mTextView.setText(a);
                }else{
                    toast("查找失败");
                }
            }
        });

        button1 = (Button)findViewById(R.id.button9);
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DriverSecondActivity.this);
                builder.setTitle("请输入名字和报价：");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                et_price = new EditText(DriverSecondActivity.this);
                builder.setView(et_price);
                builder.setPositiveButton("确定",
                        new android.content.DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int which) {
                                   Price p = new Price();
                                   String a = et_price.getText().toString().trim();
                                   p.setPrice(a);
                                   p.save(new SaveListener<String>() {
                                      @Override
                                       public void done(String s, BmobException e) {
                                            if(e==null){
                                                toast("报价成功！");
                                           }else{
                                                toast("报价失败");
                                          }
                                       }
                                    });
                                   arg0.dismiss();
                            }
                        }
                );
                builder.setNegativeButton("取消", null);
                AlertDialog dialog=builder.create();
                dialog.show();


            }

        });
    }


    private void toast(String s) {
        Toast.makeText(DriverSecondActivity.this, s, Toast.LENGTH_SHORT).show();
    }

}

