package com.ebglobalventures.animation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterCalss extends RecyclerView.Adapter<AdapterCalss.ViewHodlert>{

     private Context mContext;
     private ArrayList<ModelClass> names=new ArrayList<>();

    public AdapterCalss(Context mContext, ArrayList<ModelClass> names) {
        this.mContext = mContext;
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHodlert onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        ViewHodlert ab= new ViewHodlert(view);
        return ab;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodlert holder, final int position) {
                            holder.mName.setText(names.get(position).getName());

                            holder.mName.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String name=names.get(position).getName();
                                    try {
                                         Class toClass=Class.forName("com.ebglobalventures.animation."+name);
                                        Intent i=new Intent(mContext,toClass);
                                        mContext.startActivity(i);
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }

                                }
                            });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHodlert extends RecyclerView.ViewHolder {
        TextView mName;
        public ViewHodlert(View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.name);
        }
    }
}
