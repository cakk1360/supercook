package com.example.rushikeshbirwatkar.supercook;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FrameContainerburgers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_containerburgers);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragment_burgers fragment_burgers=new fragment_burgers();
        fragmentManager.beginTransaction().replace(R.id.framecontainerburgers,fragment_burgers).commit();

    }
}
