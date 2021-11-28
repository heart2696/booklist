package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.booklist.databinding.ActivityBookBinding;
import com.example.booklist.utils.FileUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private ActivityBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayList<String> data = new ArrayList<>();


        StudyAdapter adapter = new StudyAdapter(data);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        binding.recyclerView.setLayoutManager(layoutManager);

    }


    public String readFromAssets(String name) throws IOException {
        InputStream inputStream = getAssets().open(name);
        return FileUtils.readStream(inputStream);
    }




}