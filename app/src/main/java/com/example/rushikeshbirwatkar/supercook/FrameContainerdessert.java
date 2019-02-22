package com.example.rushikeshbirwatkar.supercook;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FrameContainerdessert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_containerdessert);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragment_dessert fragment_dessert=new fragment_dessert();
        fragmentManager.beginTransaction().replace(R.id.framecontainerdessert,fragment_dessert).commit();
    }
}
