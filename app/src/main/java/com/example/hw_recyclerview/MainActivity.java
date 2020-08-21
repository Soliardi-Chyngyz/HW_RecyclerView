package com.example.hw_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAdapter.ItemClickListener {

    public RecyclerView recyclerView;
    public MainAdapter mainAdapter;
    public EditText editText;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        final ArrayList<String> editList = new ArrayList<>();
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Log", "click is works");
                editList.add(String.valueOf(editText.getText()));
                mainAdapter.notifyDataSetChanged();
            }
        });
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(editList, this); // editList связан с MainAdapter
        recyclerView.setAdapter(mainAdapter);
        editText = findViewById(R.id.editPerson);

    }

    @Override
    public void onItemClick(int adapterPosition) {
        Toast.makeText(this, "You have clicked " + adapterPosition, Toast.LENGTH_LONG).show();
    }
}