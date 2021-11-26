package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.booklist.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            data.add("hi");
        }

        StudyAdapter adapter = new StudyAdapter(data);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        binding.recyclerView.setLayoutManager(layoutManager);
    }
}