package com.parys.alex.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager mgr = getFragmentManager();
        JavaFragment jFrag = new JavaFragment();
        FragmentTransaction trans = mgr.beginTransaction();

        trans.add(R.id.main_layout, jFrag, "JavaFragment");

        trans.commit();

    }
}
