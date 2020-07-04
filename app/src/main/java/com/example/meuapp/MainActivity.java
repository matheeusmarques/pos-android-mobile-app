package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNewMemory, btnShowMemories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnNewMemory = (Button) findViewById(R.id.btn)
//        btnShowMemories = (Button) findViewById(R.id.btn_view_memories);
//
//        btnShowMemories.setOnClickListener(buttonShowMemorie());

    }

    public void buttonNewMemory(View view){
        Intent intent = new Intent(this, NewMemory.class);
        startActivity(intent);
    }

    public void buttonShowMemories(View view){
        Intent intent = new Intent(this, ShowMemories.class);
        startActivity(intent);
    }


}
