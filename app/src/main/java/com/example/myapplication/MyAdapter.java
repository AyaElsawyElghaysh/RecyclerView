package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHloder> {
ArrayList<MyModel> models;
MyListener MyLIstener;
MainActivity mainActivity;
  public  MyAdapter(ArrayList<MyModel> list,MyListener myListener){
     this. models=list;
     this.MyLIstener=myListener;

  }

    @NonNull
    @Override
    public MyAdapter.MyViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View myView= LayoutInflater.from(parent.getContext()).
               inflate(R.layout.row_item,parent,false);
        MyViewHloder viewHloder=new MyViewHloder(myView);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHloder holder, int position) {
holder.name.setText(models.get(position).getName());
holder.imageView.setImageResource(models.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHloder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;
        public MyViewHloder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvname);
            imageView=itemView.findViewById(R.id.image_view);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 MyLIstener.getPosition(getAdapterPosition());

              }
          });
        }
    }
}
