package com.samsung.listexample.models;

public class TodoItem {
    public String head;
    public String todo;
    public boolean isChecked;

    public TodoItem(String head, String todo, boolean isChecked) {
        this.head = head;
        this.todo = todo;
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "head='" + head + '\'' +
                ", todo='" + todo + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
