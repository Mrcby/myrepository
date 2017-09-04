package com.example.administrator.transport.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.transport.R;


public class UserThirdFragment extends Fragment {
    private String context;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @SuppressLint({"NewApi", "ValidFragment"})
    public UserThirdFragment(String context) {
        this.context = context;
    }

    public UserThirdFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_thirdfragment, container, false);

        //获得窗体传递来的数据
        Bundle bundle = UserThirdFragment.this.getArguments();
        final String drivername = bundle.getString("msg");
        Toast.makeText(getActivity(),drivername,Toast.LENGTH_SHORT);

        button1 = (Button) view.findViewById(R.id.button21);
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                startActivity(intent);
            }

        });

        button2 = (Button) view.findViewById(R.id.button22);
        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserResetpwdActivity.class);
                startActivity(intent);
            }
        });
        button3 = (Button) view.findViewById(R.id.button23);
        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserWalletActivity.class);
                startActivity(intent);
            }
        });
        button4 = (Button) view.findViewById(R.id.button24);
        button4.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
//              ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
//              manager.killBackgroundProcesses(getActivity().getPackageName());
                Intent intent = new Intent(getActivity(), LoginSelectorActivity.class);
                startActivity(intent);
            }

        });
        return view;
    }
}
