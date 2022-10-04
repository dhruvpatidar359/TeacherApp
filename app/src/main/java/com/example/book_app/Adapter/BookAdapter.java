package com.example.book_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_app.Models.Datatypes;
import com.example.book_app.PdfViewer;
import com.example.book_app.R;
import com.example.book_app.SampleBooks;
import com.example.book_app.Storyview;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewAdapter> {

    ArrayList<Datatypes> list;
    Context context;

    public BookAdapter(ArrayList<Datatypes> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_books,parent,false);


        return new  ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
    Datatypes data = list.get(position);
//    holder.img.setImageResource(data.getImage());

    Picasso.get()
            .load(data.getImage())
            .into(holder.img);

    holder.text.setText(data.getName());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, Storyview.class);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewAdapter extends RecyclerView.ViewHolder{
        ImageView img;

        TextView text;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.imageView);

            text = itemView.findViewById(R.id.textView);

        }
    }
}
