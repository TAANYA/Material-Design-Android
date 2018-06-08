package com.example.tanya.material_design1;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter_recycler extends RecyclerView.Adapter<Adapter_recycler.ViewHolder>
{

    private List<List_recycler> listItems;
    private Context context;

    public Adapter_recycler(List<List_recycler> listItems, Context context)
    {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_recycler, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_recycler listItem = listItems.get(position);

        holder.textViewhead.setText(listItem.getHead());
        holder.textViewdesc.setText(listItem.getDesc());
        Glide.with(context).load(listItem.getImgUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewhead, textViewdesc;
        ImageView image;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textViewhead = (TextView) itemView.findViewById(R.id.texthead);
            textViewdesc = (TextView) itemView.findViewById(R.id.textdesc);
            image = (ImageView) itemView.findViewById(R.id.imgView);

        }
    }
}