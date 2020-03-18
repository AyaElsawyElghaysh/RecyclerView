package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyListener {
RecyclerView list;
     MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.recycle);
        list.setLayoutManager(new LinearLayoutManager(this));
       list.setHasFixedSize(true);
        ArrayList<MyModel> arrayList=new ArrayList<>();
        MyModel myModel=new MyModel
                (R.drawable.ic_launcher_background,"aya");
        arrayList.add(myModel);
        arrayList.add(new MyModel
                (R.drawable.ic_launcher_foreground,"eman"));
         adapter=new MyAdapter(arrayList, new MyListener() {
             @Override
             public void getPosition(int position) {
                 Toast.makeText(MainActivity.this, "item position is at"+position, Toast.LENGTH_SHORT).show();
             }
         });
    list.setAdapter(adapter);
    }

    @Override
    public void getPosition(int position) {
        Toast.makeText(MainActivity.this, "item position is at"+position, Toast.LENGTH_SHORT).show();

    }
    public void setName(){
        String name="aya";
    }
}
