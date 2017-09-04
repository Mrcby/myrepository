package com.example.administrator.transport.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.transport.R;



public class DriverMainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView topBar;
    private TextView tabDeal;
    private TextView tabPoi;


    private TextView tabUser;

    private FrameLayout ly_content;

    private FirstFragment f1;
    private SecondFragment f2;
    private ThirdFragment f3;
    String drivername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drivermain);
        Intent intent = getIntent();
        drivername = intent.getStringExtra("drivername");
        Toast.makeText(DriverMainActivity.this,drivername,Toast.LENGTH_SHORT);
        bindView();

    }

    //UI组件初始化与事件绑定
    private void bindView() {
        topBar = (TextView) this.findViewById(R.id.txt_top);
        tabDeal = (TextView) this.findViewById(R.id.txt_deal);
        tabPoi = (TextView) this.findViewById(R.id.txt_poi);
        tabUser = (TextView) this.findViewById(R.id.txt_user);

        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabDeal.setOnClickListener(this);

        tabUser.setOnClickListener(this);
        tabPoi.setOnClickListener(this);

    }

    //重置所有文本的选中状态
    public void selected() {
        tabDeal.setSelected(false);

        tabPoi.setSelected(false);
        tabUser.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }

        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()) {
            case R.id.txt_deal:
                selected();
                tabDeal.setSelected(true);
                if (f1 == null) {
                    f1 = new FirstFragment("货运新闻资讯");
                    transaction.add(R.id.fragment_container, f1);
                } else {
                    transaction.show(f1);
                }
                break;

            case R.id.txt_poi:
                selected();
                tabPoi.setSelected(true);
                if (f2 == null) {
                    f2 = new SecondFragment(" ");
                    transaction.add(R.id.fragment_container, f2);
                } else {
                    transaction.show(f2);
                }
                break;

            case R.id.txt_user:
                selected();
                tabUser.setSelected(true);
                if (f3 == null) {
                    f3 = new ThirdFragment(" ");
                    Bundle bundle = new Bundle();
                    bundle.putString("msg",drivername);
                    f3.setArguments(bundle);
                    transaction.add(R.id.fragment_container, f3);
                } else {
                    transaction.show(f3);
                }
                break;
        }

        transaction.commit();
    }


}