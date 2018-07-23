package com.ebglobalventures.animation;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTransition2 extends AppCompatActivity {
    private Button mback;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);
        initPAGE();
        initTransition();
    }


    private void initPAGE() {
        mback=findViewById(R.id.back_button2);
        Intent i=getIntent();
         type=i.getExtras().getString("key").toString();

        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }

    private void initTransition() {
             switch(type){
                 case "explode":
                     Explode enterTransition = new Explode();
                     enterTransition.setDuration(1000);
                     getWindow().setEnterTransition(enterTransition);
                     break;
                 case "slide":
                     Slide enterTransition1 = new Slide();
                     enterTransition1.setSlideEdge(Gravity.LEFT);
                     enterTransition1.setDuration(1000);
                     enterTransition1.setInterpolator(new AnticipateOvershootInterpolator());
                     getWindow().setEnterTransition(enterTransition1);
                     break;
                 case "fade":
                     Fade enterTransition2 = new Fade();
                     enterTransition2.setDuration(1000);
                     getWindow().setEnterTransition(enterTransition2);
                     break;
                 default:
                     Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
             }

    }
}
