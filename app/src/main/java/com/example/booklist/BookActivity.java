package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;

import com.example.booklist.databinding.ActivityBookBinding;

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

        try {
            String book = readFromAssets("books.json");
            JSONObject bookItem = new JSONObject(book);
            String text = bookItem.getString("title") +
                    bookItem.getString("author") +
                    bookItem.getString("description");
            binding.textview.setText(text);
        }catch (IOException e) {
            Log.i("DEBUG", "파일 읽기 실패");
        }
        catch (JSONException e){
            Log.i("DEBUG", "JSON 읽기 실패");

        }


        ArrayList<String> data = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            data.add("안녕하세요" + (i + 1));
//        }

        StudyAdapter adapter = new StudyAdapter(data);
        binding.recyclerView2.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        binding.recyclerView2.setLayoutManager(layoutManager);

    }

    public String readFromAssets(String name) throws IOException {
        InputStream inputStream = getAssets().open(name);
        return FileUtils.readStream(inputStream);
    }


//
//
//    public static String readFile(Context context, String filename) throws FileNotFoundException {
//        FileInputStream fis = context.openFileInput(filename);
//        String contents = "";
//        InputStreamReader inputStreamReader =
//                new InputStreamReader(fis, StandardCharsets.UTF_8);
//        StringBuilder stringBuilder = new StringBuilder();
//
//        try(BufferedReader reader = new BufferedReader(inputStreamReader)) {
//            String line = reader.readLine();
//            while (line != null) {
//                stringBuilder.append(line).append('\n');
//                line = reader.readLine();
//            }
//        }catch (IOException e) {
//
//        }finally {
//            contents = stringBuilder.toString().trim();
//        }
//        return contents;
//    }
//
//    private void writeFile(String filename, String data){
//        try{
//            FileOutputStream fos=openFileOutput(filename, Context.MODE_PRIVATE);
//            fos.write(data.getBytes(StandardCharsets.UTF_8));
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}