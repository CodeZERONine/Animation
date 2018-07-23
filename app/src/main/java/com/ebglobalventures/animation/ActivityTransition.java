package com.ebglobalventures.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTransition extends AppCompatActivity implements View.OnClickListener{
   private TextView mText;
   private ImageView mImageView1, mImageView2;
   private TextView mCircularReveal;
   private Button explodeJava, slideJava,fadeJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        mText=findViewById(R.id.text1);
        mImageView1=findViewById(R.id.image1);
        mImageView2=findViewById(R.id.image2);
        explodeJava=findViewById(R.id.explode_java_button);
        slideJava=findViewById(R.id.slide_java_button);
        fadeJava=findViewById(R.id.fade_java_button);
        mCircularReveal=findViewById(R.id.circularReveal);

        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair[] pairs=new Pair[3];
                pairs[0]= new Pair<View, String>(mText,"text1");
                pairs[1]= new Pair<View, String>(mImageView1,"image1");
                pairs[2]= new Pair<View, String>(mImageView2,"image2");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(ActivityTransition.this,pairs);
                Intent i=new Intent(ActivityTransition.this, SharedElementsActivity.class);
                startActivity(i,options.toBundle());
            }
        });

        mCircularReveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            makeCircularReveal(mCircularReveal);
            }
        });

        explodeJava.setOnClickListener(this);
        slideJava.setOnClickListener(this);
        fadeJava.setOnClickListener(this);
        setupWindowAnimations();
    }
    //For backactivity transition
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right - to - left locale
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
    }

    private void makeCircularReveal(View view) {
         final TextView mTextView3=findViewById(R.id.inviTextview);
         //finding the center of the View
        int centerX=(view.getLeft() + view.getRight())/2;
        int centerY=(view.getTop() + view.getBottom())/2;
        //finding out the radius
         float radius= Math.max(mTextView3.getWidth(), mTextView3.getHeight()) * 2.0f;
        if (mTextView3.getVisibility() == View.INVISIBLE) {
            mTextView3.setVisibility(View.VISIBLE);
            mTextView3.setText("Waka Waka!");

            ViewAnimationUtils.createCircularReveal(mTextView3, centerX, centerY, 0, radius).start();
        } else {
            Animator reveal = ViewAnimationUtils.createCircularReveal(mTextView3, centerX, centerY, radius, 0);
            reveal.addListener(new AnimatorListenerAdapter(){
                public void onAnimationEnd(Animator animation) {
                    mTextView3.setVisibility(View.INVISIBLE);
                }
            });
            reveal.start();
        }

    }

    @Override
    public void onClick(View v) {
          switch(v.getId()){
              case R.id.explode_java_button:
                  ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                  Intent i = new Intent(ActivityTransition.this,ActivityTransition2.class);
                  i.putExtra("key","explode");
                  Toast.makeText(this, "launch", Toast.LENGTH_SHORT).show();
                  startActivity(i, options.toBundle());
                  break;
              case R.id.explode_xml_button:break;
              case R.id.slide_java_button:
                  ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation(this);
                  Intent i1 = new Intent(ActivityTransition.this, ActivityTransition2.class);
                  i1.putExtra("key", "slide");
                  startActivity(i1, options1.toBundle());
                  break;
              case R.id.slide_xml_button: break;
              case R.id.fade_java_button:
                  ActivityOptions options3 = ActivityOptions.makeSceneTransitionAnimation(this);
                  Intent i2= new Intent(ActivityTransition.this, ActivityTransition2.class);
                  i2.putExtra("key", "fade");
                  startActivity(i2, options3.toBundle());
                  break;
              case R.id.fade_xml_button:break;
              default:break;
          }
    }
}
