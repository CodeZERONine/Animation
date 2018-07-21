package com.ebglobalventures.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        temp.add(new ModelClass("ActivtiyThree"));
        temp.add(new ModelClass("ActivtiyFour"));
        temp.add(new ModelClass("ActivtiyFive"));
        mActivtiyList=temp;
        }
}
