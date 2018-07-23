package com.ebglobalventures.animation;

import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Spring extends AppCompatActivity {
    private ImageView mImageView;
    private Button mButton, mBack, mBounce;
    private float xCoOrdiante,yCoOrdinate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);
        mImageView=findViewById(R.id.imageView);
        mButton=findViewById(R.id.button);
        mBack=findViewById(R.id.button2);
        mBounce=findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlingAnimation fling=new FlingAnimation(mImageView, DynamicAnimation.X);
                fling.setStartVelocity(-500f);
                fling.setFriction(0.5f);
                fling.start();
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlingAnimation fling=new FlingAnimation(mImageView, DynamicAnimation.X);
                fling.setStartVelocity(500f);
                fling.setFriction(.5f);
                fling.start();
            }
        });
        mBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      SpringAnimation springAnimation= new SpringAnimation(mImageView,DynamicAnimation.Y);
                      //Control the behaviour of the spring
                SpringForce springForce = new SpringForce();
                springForce.setFinalPosition(mImageView.getY());
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                springForce.setStiffness(SpringForce.STIFFNESS_LOW);

                springAnimation.setSpring(springForce);
                springAnimation.setStartVelocity(4000f);
                springAnimation.start();
                springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                                                 mImageView.setImageResource(R.drawable.ic_launcher_foreground2);

                    }
                });
            }
        });

         mImageView.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                   switch(event.getActionMasked())
                   {
                       case MotionEvent.ACTION_DOWN:
                              xCoOrdiante= mImageView.getX()-event.getRawX();
                              yCoOrdinate=mImageView.getY()-event.getRawY();
                              break;
                       case MotionEvent.ACTION_MOVE:
                             v.animate().x(event.getRawX() + xCoOrdiante).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                             break;
                       default: return false;
                   }
                   return true;
             }
         });


    }
}
