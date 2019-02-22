package com.example.rushikeshbirwatkar.supercook;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FrameContainernonveg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_containernonveg);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragment_nonveg fragment_nonveg=new fragment_nonveg();
        fragmentManager.beginTransaction().replace(R.id.framecontainernonveg,fragment_nonveg).commit();

    }
}
