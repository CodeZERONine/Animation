package com.ebglobalventures.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private RecyclerView mRecyclerVeiw;
   private ArrayList<ModelClass> mActivtiyList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerVeiw=findViewById(R.id.recyclerView);
        initList();
        initRecycler();
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

    private void initRecycler() {
        AdapterCalss adapter = new AdapterCalss(this, mActivtiyList);
        mRecyclerVeiw.setAdapter(adapter);
        mRecyclerVeiw.setLayoutManager(new LinearLayoutManager(this));
    }

    private void  initList() {
        ArrayList<ModelClass> temp=new ArrayList<>();
              temp.add(new ModelClass("TouchFeedBackAnimation"));
        temp.add(new ModelClass("ActivityTransition"));
        temp.add(new ModelClass("CircularRevealActivity"));
        temp.add(new ModelClass("MoveViewActivity"));
        temp.add(new ModelClass("MoveViewCurverd"));
        temp.add(new ModelClass("FlingMotion"));
        temp.add(new ModelClass("EnlargeViewZoom"));
        temp.add(new ModelClass("Spring"));


        mActivtiyList=temp;
        }
}
