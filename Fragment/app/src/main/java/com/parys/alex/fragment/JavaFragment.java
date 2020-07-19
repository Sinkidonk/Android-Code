package com.parys.alex.fragment;

/**
 * Created by apary on 10/17/2017.
 */


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Debug;
import android.widget.Button;
import android.widget.TextView;


public class JavaFragment extends Fragment {
    public Button button;
    public TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.java_layout, container, false);
        button = (Button) view.findViewById(R.id.button);
        textView = (TextView) view.findViewById(R.id.textView2);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button Click");
            }
        });
        return view;
    }

}
