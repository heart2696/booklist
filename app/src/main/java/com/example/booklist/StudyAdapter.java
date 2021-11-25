package com.example.booklist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklist.databinding.ItemStudyBinding;

import java.util.ArrayList;


public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.ViewHolder>{
    private final ArrayList<String> data;

    public StudyAdapter(ArrayList<String> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemStudyBinding binding = ItemStudyBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String hello = data.get(position);
        holder.binding.textview.setText(hello);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        private final ItemStudyBinding binding;

        public ViewHolder(ItemStudyBinding binding){
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}

