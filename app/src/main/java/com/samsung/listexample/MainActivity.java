package com.samsung.listexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.samsung.listexample.models.TodoItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<TodoItem> todoItems = new ArrayList<>();

    public void initItems() {
        todoItems.add(new TodoItem("Item 1", "check", true));
        todoItems.add(new TodoItem("Simper", "check", true));
        todoItems.add(new TodoItem("Text here", "check", true));

//        todoItems.add(new TodoItem("Item 31231", "check", true));
//        todoItems.add(new TodoItem("Sdasdaimpel", "check", true));
//        todoItems.add(new TodoItem("Text dfsfhere", "che204ck", true));
//        todoItems.add(new TodoItem("Itedasdm 1", "chec204k", true));
//        todoItems.add(new TodoItem("Siddasddasdafsfmpel", "c204heck", true));
//        todoItems.add(new TodoItem("Text here", "ch204eck", true));
//        todoItems.add(new TodoItem("Itdfdasddasdasfem 1", "c204heck", true));
//        todoItems.add(new TodoItem("Sidfdasdasfmpel", "ch204eck", true));
//        todoItems.add(new TodoItem("Textdasdsdasddasda here", "chec204k", true));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItems();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        RecyclerView recyclerView = findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(todoItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton actionButton = findViewById(R.id.floatingActionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                todoItems.add(new TodoItem("Item " + random.nextInt(), "check" + random.nextInt(), false));
                adapter.notifyDataSetChanged();
            }
        });
    }
}