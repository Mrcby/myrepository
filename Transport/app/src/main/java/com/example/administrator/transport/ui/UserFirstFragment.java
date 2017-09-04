package com.example.administrator.transport.ui;

        import android.annotation.SuppressLint;
        import android.app.Fragment;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.example.administrator.transport.R;


public class UserFirstFragment extends Fragment {
    private String context;
    private TextView mTextView;

    @SuppressLint({"NewApi", "ValidFragment"})
    public  UserFirstFragment(String context){
        this.context = context;
    }
    public  UserFirstFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_firstfragment,container,false);
        mTextView = (TextView)view.findViewById(R.id.txt_content1);

        mTextView.setText(context);
        return view;
    }
}