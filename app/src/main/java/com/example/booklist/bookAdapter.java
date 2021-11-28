package com.example.booklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.booklist.databinding.ItemBookBinding;
import com.example.booklist.databinding.ItemStudyBinding;
import com.google.gson.Gson;

import java.util.ArrayList;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.ViewHolder>{
//    ArrayList<BookItemLists> bookLists = new ArrayList<BookItemLists>();
    private final ArrayList<String> data;
    public bookAdapter(ArrayList<String> data) {
        this.data = data;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
//        return new ViewHolder(view);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBookBinding binding = ItemBookBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder ViewHolder, int position) {
//        String author = data.get(position);
//        holder.binding.author.setText(author);
        BookItemLists book = this.data.get(position);
        ViewHolder.binding.textauthor.setText(book.getAuthor());
        ViewHolder.binding.texttitle.setText(book.getTitle());
        ViewHolder.binding.textdescription.setText(book.getDescription());



//        ViewHolder.onBind(bookLists.get(position));

    }
//        RecyclerView.ViewHolder.onBind(bookLists.get(position));





    @Override
    public int getItemCount() {return data.size();}

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        private final ItemBookBinding binding;

        public ViewHolder(ItemBookBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }


//        return bookLists.size();
//    }
//
//
//
//    public void addItem(BookItemLists book) {
//        bookLists.add(book);
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView title;
//        private TextView author;
//        private TextView description;
//        private ImageView image;
//
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            title = itemView.findViewById(R.id.texttitle);
//            author = itemView.findViewById(R.id.textauthor);
//            description = itemView.findViewById(R.id.textdescription);
//            image = itemView.findViewById(R.id.image);
//        }
//
//        void onBind(BookItemLists book) {
//            title.setText(book.getTitle());
//            author.setText(book.getAuthor());
//            description.setText(book.getDescription());
//
//
//
//        }
//    }



}
