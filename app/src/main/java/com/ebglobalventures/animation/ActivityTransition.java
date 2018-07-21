package com.ebglobalventures.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityTransition extends AppCompatActivity implements View.OnClickListener{
   private TextView mText;
   private ImageView mImageView1, mImageView2;
   private TextView mCircularReveal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        mText=findViewById(R.id.text1);
        mImageView1=findViewById(R.id.image1);
        mImageView2=findViewById(R.id.image2);
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
              case R.id.explode_java_button:break;
              case R.id.explode_xml_button:break;
              case R.id.slide_java_button:break;
              case R.id.slide_xml_button: break;
              case R.id.fade_java_button:break;
              case R.id.fade_xml_button:break;
              default:break;
          }
    }
}
