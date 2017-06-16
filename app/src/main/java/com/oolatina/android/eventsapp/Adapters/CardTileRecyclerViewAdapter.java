package com.oolatina.android.eventsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oolatina.android.eventsapp.Activities.EventsExploreActivity;
import com.oolatina.android.eventsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharatwaaj on 17-05-2016.
 */

public class CardTileRecyclerViewAdapter extends RecyclerView.Adapter<CardTileRecyclerViewAdapter.CardTileViewHolder> {

    private LayoutInflater inflater;
    private ViewGroup viewGroup;
    private List<String> arrayList = new ArrayList<>();

    public CardTileRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        arrayList.add("Class");
        arrayList.add("Party");
        arrayList.add("Show");
        arrayList.add("Workshop");
        arrayList.add("Concert");
    }

    @Override
    public CardTileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_cardview_tile, parent, false);
        CardTileViewHolder cardTileViewHolder = new CardTileViewHolder(view);
        this.viewGroup = parent;
        return cardTileViewHolder;
    }

    @Override
    public void onBindViewHolder(final CardTileViewHolder holder, int position) {

        final Context context = viewGroup.getContext();

        holder.cardViewTileTitle.setText(arrayList.get(position));

        //   Category On Click Event Handler
        holder.cardViewTile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventsExploreActivity.class);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CardTileViewHolder extends RecyclerView.ViewHolder {
        TextView cardViewTileTitle;
        RelativeLayout cardViewTile;
        ImageView cardViewTileImage;

        public CardTileViewHolder(View itemView) {
            super(itemView);
            cardViewTile = (RelativeLayout) itemView.findViewById(R.id.cardview_tile);
            cardViewTileImage = (ImageView) itemView.findViewById(R.id.cardview_tile_image);
            cardViewTileTitle = (TextView) itemView.findViewById(R.id.cardview_tile_title);
        }
    }


}
