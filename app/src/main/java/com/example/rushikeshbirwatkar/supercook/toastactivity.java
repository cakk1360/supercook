package com.example.rushikeshbirwatkar.supercook;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class toastactivity extends AppCompatActivity {

    ImageView vegimg,nonvegimg,burgerimg,dessertimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toastactivity);

        vegimg=findViewById(R.id.vegimg);
        nonvegimg=findViewById(R.id.nonvegimg);
burgerimg=findViewById(R.id.burgerimg);
dessertimg=findViewById(R.id.dessertimg);


        vegimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(toastactivity.this,FrameContainer.class);
                startActivity(intent);
            }
        });

        nonvegimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(toastactivity.this,FrameContainernonveg.class);
                startActivity(intent);
            }
        });

burgerimg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(toastactivity.this,FrameContainerburgers.class);
        startActivity(intent);
    }
});

dessertimg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(toastactivity.this,FrameContainerdessert.class);
        startActivity(intent);
    }
});
    }

}
