package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.meuapp.model.myMemory;

import java.util.List;

public class ShowMemories extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_memories);
        listView = (ListView) findViewById(R.id.listMemories);
        listView.setOnItemClickListener(this);
        loadList();
    }

    private void loadList(){
        List<myMemory> myMemories = myMemory.find(myMemory.class, "id>0");
        ListView listView = (ListView) findViewById(R.id.listMemories);

        ListMemoriesAdapter adapter = new ListMemoriesAdapter(this, myMemories);

        listView.setAdapter(adapter);
    }

    public void callDetails(View view){
        Intent itt = new Intent(this, DetailsRegister.class);
        startActivity(itt);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        myMemory memoryActivity = (myMemory) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, DetailsRegister.class);

        intent.putExtra("id", memoryActivity.getId());
        startActivity(intent);
    }
}
