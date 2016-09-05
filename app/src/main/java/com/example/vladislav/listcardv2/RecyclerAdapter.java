package com.example.vladislav.listcardv2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private String[] titles = {"Brian Kernighan",
            "Linus Torvalds",
            "Bjarne Stroustrup"};

    private String[] details = {"Kernighan became famous by co-authoring the very first book on the C programming language and " +
            "by authoring many UNIX programs such as ditroff, and cron for Version 7 Unix. His other notable work include his " +
            "popular criticisms for Pascal called “Why Pascal is Not My Favorite Programming Language”.",


            "Without Stallman and GNU, there would be no Linux. Without Torvalds, " +
                    "there would be no GNU kernel. There’d also be no git. While Torvalds is the first to admit that" +
                    " he spends most of his time merging code written by thousands of Linux kernel contributors rather " +
                    "than programming it himself, the developer that launched a hundred distros is worth his place on the list.",


            "The man who brought us C++ and, indirectly, popularised object-oriented programming. " +
                    "He once said that looking at “average” pieces of code “can make me cry.” " +
                    "You can check out some of his more memorable quotes here."};

    private int[]images = {R.drawable.kernighan,
            R.drawable.linus,
            R.drawable.stroustrup};

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}