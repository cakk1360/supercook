package com.example.rushikeshbirwatkar.supercook;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FrameContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_container);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragment_veg fragmentVeg=new fragment_veg();
        fragmentManager.beginTransaction().replace(R.id.framecontainer,fragmentVeg).commit();
    }
}
