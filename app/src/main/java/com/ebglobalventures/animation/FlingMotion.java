package com.ebglobalventures.animation;

import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FlingMotion extends AppCompatActivity {
    private ImageView mImageView;
    private Button mButton, mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling_motion);
        mImageView=findViewById(R.id.imageView);
        mButton=findViewById(R.id.button);
        mBack=findViewById(R.id.button2);
    mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FlingAnimation fling=new FlingAnimation(mImageView, DynamicAnimation.X);
            fling.setStartVelocity(-500f);
            fling.setFriction(0.1f);
            fling.start();
        }
    });
   mBack.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           FlingAnimation fling=new FlingAnimation(mImageView, DynamicAnimation.X);
           fling.setStartVelocity(500f);
           fling.setFriction(1.5f);
           fling.start();
       }
   });

    }
}
