package com.ebglobalventures.animation;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MoveViewCurverd extends AppCompatActivity {
    private ImageView mImageView;
    private Button mButton;
    PathInterpolator pathInterpolator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_view_curverd);
        mImageView=findViewById(R.id.imageView2);
        mButton=findViewById(R.id.button3);



        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Path path=new Path();
          path.arcTo(0f,0f,1000f,1000f,270f,180f,true);

            ObjectAnimator animator= ObjectAnimator.ofFloat(mImageView,View.X, View.Y, path);
            animator.setDuration(1000);
            animator.start();
            //pathInterpolator =new PathInterpolator(path);
        }

          mButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                      Path path=new Path();
                     path.arcTo(0f,0f,1000f,1000f,270f,180f,true);
                     // path.addCircle(mImageView.getX(),mImageView.getY(),150,Path.Direction.CW);
                       // path.addRect(80f,30f,800f,600f,Path.Direction.CW);



                      ObjectAnimator animator= ObjectAnimator.ofFloat(mImageView, View.X, View.Y, path);
                      animator.setDuration(1000);
                      animator.start();
                      //pathInterpolator =new PathInterpolator(path);
                  }


                 // animator.setInterpolator(pathInterpolator);

              }
          });
    }

}
