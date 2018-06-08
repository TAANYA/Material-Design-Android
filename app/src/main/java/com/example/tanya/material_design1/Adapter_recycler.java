package com.example.tanya.material_design1;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter_recycler extends RecyclerView.Adapter<Adapter_recycler.ViewHolder>
{

    private List<Superheroes> listItems;
    private Context context;
    Frag_recycler frag;

    public Adapter_recycler(List<Superheroes> listItems, Context context, Frag_recycler frag)
    {
        this.listItems = listItems;
        this.context = context;
        this.frag = frag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_recycler, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Superheroes listItem = listItems.get(position);

        holder.textViewhead.setText(listItem.getHead());
        holder.textViewdesc.setText(listItem.getDesc());
        Glide.with(context).load(listItem.getUrl()).into(holder.image);
        holder.linearLayout.setTag(String.valueOf(position));

        int i = position%2;

        if(i == 0)
        {
            holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        else
        {
            holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.color3));
        }

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewhead, textViewdesc;
        ImageView image;
        LinearLayout linearLayout;
        CardView cardView;

        public ViewHolder(final View itemView)
        {
            super(itemView);

            textViewhead = (TextView) itemView.findViewById(R.id.texthead);
            textViewdesc = (TextView) itemView.findViewById(R.id.textdesc);
            image = (ImageView) itemView.findViewById(R.id.imgView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linear);
            cardView = (CardView)itemView.findViewById(R.id.cardView);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Custom_dialog_add dialog = new Custom_dialog_add(context,frag);
                    dialog.show();
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View view)
                {
                    int pos = Integer.parseInt( view.getTag().toString());
                    listItems.remove(pos);
                    Toast.makeText(context, "entry removed" + pos, Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                    return false;
                }
            });

        }
    }
}