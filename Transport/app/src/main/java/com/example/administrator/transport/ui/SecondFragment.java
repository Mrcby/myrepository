package com.example.administrator.transport.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.transport.R;


public class SecondFragment extends Fragment {
    private String context;
    private Button b;

    @SuppressLint({"NewApi", "ValidFragment"})
    public SecondFragment(String context){
        this.context = context;
    }
    public SecondFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        b = (Button) view.findViewById(R.id.button8);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DriverSecondActivity.class);
                startActivity(intent);
            }

        });
        return view;
    }
}
