package com.example.walpe;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class WalpeRecyclerViewAdapter extends RecyclerView.Adapter<WalpeViewHolder> {

    List<WalpeImageData> list = Collections.emptyList();
    Context context;

    public WalpeRecyclerViewAdapter(List<WalpeImageData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public WalpeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        WalpeViewHolder holder = new WalpeViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(WalpeViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
//        holder.imageView.setImageURI(Uri.parse(String.valueOf(list.get(position).imageId)));
        holder.imageView.setImageURI(Uri.parse(list.get(position).imageId));


        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, WalpeImageData data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified WalpeImageData object
    public void remove(WalpeImageData data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
