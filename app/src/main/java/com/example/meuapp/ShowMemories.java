package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.meuapp.model.myMemory;

import java.util.List;

public class ShowMemories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_memories);
        loadList();
    }

    private void loadList(){
        List<myMemory> myMemories = myMemory.find(myMemory.class, "id>0");
        ListView listView = (ListView) findViewById(R.id.listMemories);

        ListMemoriesAdapter adapter = new ListMemoriesAdapter(this, myMemories);

        listView.setAdapter(adapter);
    }
}
