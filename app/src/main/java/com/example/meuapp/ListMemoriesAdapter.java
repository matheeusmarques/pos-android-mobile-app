package com.example.meuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meuapp.model.myMemory;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ListMemoriesAdapter extends BaseAdapter {
    Context context;
    List<myMemory> memories;

    public ListMemoriesAdapter(Context context, List<myMemory> memories) {
        this.context = context;
        this.memories = memories;
    }

    @Override
    public int getCount() {
        return memories.size();
    }

    @Override
    public Object getItem(int position) {
        return memories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return memories.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = LayoutInflater.from(context).inflate(R.layout.rowmemory, parent, false);
        myMemory myMemory = memories.get(position);
        TextView textView = row.findViewById(R.id.textTitleRow);
        textView.setText(myMemory.getTitle());


        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        TextView memoryDate = row.findViewById(R.id.textDateRow);
        memoryDate.setText(format.format(myMemory.getDate_memory()));

        return row;
    }
}
