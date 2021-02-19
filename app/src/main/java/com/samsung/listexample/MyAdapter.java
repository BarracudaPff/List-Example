package com.samsung.listexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samsung.listexample.models.TodoItem;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<TodoItem> todoItems;

    public MyAdapter(ArrayList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_checklist, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TodoItem item = todoItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView headView;
        final CheckBox boxView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            headView = itemView.findViewById(R.id.headView);
            boxView = itemView.findViewById(R.id.checkBox);
        }

        public void bind(TodoItem item) {
            headView.setText(item.head);
            boxView.setText(item.todo);
            boxView.setChecked(item.isChecked);

            boxView.setOnClickListener(v -> item.isChecked = boxView.isChecked());
        }
    }
}
