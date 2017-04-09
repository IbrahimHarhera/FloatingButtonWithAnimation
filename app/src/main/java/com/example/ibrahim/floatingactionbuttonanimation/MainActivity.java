package com.example.ibrahim.floatingactionbuttonanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab1,fab2,fab3;
    Animation fabOpen,fabClose,fabClockwise,fabAntiClockwise;

    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
        fab3=(FloatingActionButton)findViewById(R.id.fab3);

        fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(this,R.anim.fab_close);
        fabClockwise= AnimationUtils.loadAnimation(this,R.anim.rotate_clockwise);
        fabAntiClockwise= AnimationUtils.loadAnimation(this,R.anim.rotate_anticlockwise);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){

                    fab2.startAnimation(fabClose);
                    fab3.startAnimation(fabClose);
                    fab1.startAnimation(fabAntiClockwise);
                    fab2.setClickable(false);
                    fab3.setClickable(false);

                    isOpen=false;
                }else {
                    fab2.startAnimation(fabOpen);
                    fab3.startAnimation(fabOpen);
                    fab1.startAnimation(fabClockwise);
                    fab2.setClickable(true);
                    fab3.setClickable(true);

                    isOpen=true;
                }
            }
        });
    }
}
