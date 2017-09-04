package com.example.administrator.transport.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.transport.R;


public class UserSecondFragment extends Fragment {
    private String context;
    private Button b1;
    private Button b2;

    @SuppressLint({"NewApi", "ValidFragment"})
    public UserSecondFragment(String context){
        this.context = context;
    }
    public UserSecondFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_secondfragment2, container, false);

        b1 = (Button) view.findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserSecondActivity.class);
                startActivity(intent);
            }

        });

        b2 = (Button) view.findViewById(R.id.button10);
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserFindPriceActivity.class);
                startActivity(intent);
            }

        });
        return view;
    }


}
