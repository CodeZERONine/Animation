package com.ebglobalventures.animation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MoveViewActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Button mButton,mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_view);
        mImageView=findViewById(R.id.imageView1);
        mButton=findViewById(R.id.button);
        mBack=findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim=ObjectAnimator.ofFloat(mImageView,"translationX",100f);
                anim.setDuration(1000);
                ObjectAnimator anim2=ObjectAnimator.ofFloat(mImageView,"translationY",100f);
                anim2.setDuration(1000);
                anim.start();
                anim2.start();
               // reverse();
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim2=ObjectAnimator.ofFloat(mImageView,"translationX",00f);
                anim2.setDuration(1000);
                anim2.start();
                ObjectAnimator anim3=ObjectAnimator.ofFloat(mImageView,"translationY",00f);
                anim3.setDuration(1000);
                anim3.start();
            }
        });
    }


}
