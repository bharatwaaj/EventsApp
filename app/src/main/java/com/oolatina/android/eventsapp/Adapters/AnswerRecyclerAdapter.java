package com.oolatina.android.eventsapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oolatina.android.eventsapp.Activities.EventsExploreActivity;
import com.oolatina.android.eventsapp.Others.AnimationUtils;
import com.oolatina.android.eventsapp.Others.Const;
import com.oolatina.android.eventsapp.R;
import com.oolatina.android.eventsapp.Widgets.ETextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bharatwaaj on 15-06-2017.
 */

public class AnswerRecyclerAdapter extends RecyclerView.Adapter<AnswerRecyclerAdapter.AnswerViewHolder> {



    private Context context;
    private LayoutInflater inflater;
    private ViewGroup viewGroup;
    private List<String> optionsList = new ArrayList<>();

    public AnswerRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setOptionsList(int position) {
        if (position == Const.TAG_ACTIVITY_IDENTITY) {
            // Adding Activity List
            optionsList.clear();
            optionsList.add("Dance");
            optionsList.add("Music");
        } else if (position == Const.TAG_STYLE_IDENTITY) {
            // Adding Activity List
            optionsList.clear();
            optionsList.add("Salsa");
            optionsList.add("Cuban Salsa");
            optionsList.add("Portorican Salsa");
            optionsList.add("Columbian Salsa");
            optionsList.add("Hip Hop Salsa");
            optionsList.add("Son");
            optionsList.add("Timba");
            optionsList.add("Mambo");
            optionsList.add("Danzon");
            optionsList.add("Habanera");
            optionsList.add("Guajira");
            optionsList.add("Vallenato");
            optionsList.add("Ranchera");
            optionsList.add("Corrido");
            optionsList.add("Bachata");
            optionsList.add("Reggaeton");
            optionsList.add("Kizomba");
            optionsList.add("Semba");
            optionsList.add("Cumbia");
            optionsList.add("Tango");
            optionsList.add("Bolero");
            optionsList.add("Chacha");
            optionsList.add("Kuduro");
            optionsList.add("Merengue");
            optionsList.add("Pachanga");
            optionsList.add("Paso doble");
            optionsList.add("Rumba");
        } else if (position == Const.TAG_LEVEL_IDENTITY) {
            optionsList.clear();
            optionsList.add("Beginner");
            optionsList.add("Beginner/Intermediate");
            optionsList.add("Intermediate");
            optionsList.add("Intermediate/Advanced");
            optionsList.add("Advanced");
        } else if (position == Const.TAG_MOMENT_IDENTITY) {
            optionsList.clear();
            optionsList.add("Choose Date");
            optionsList.add("Choose Start Time");
            optionsList.add("Choose End Time");
        } else if (position == Const.TAG_PRICE_IDENTITY) {
            optionsList.clear();
            optionsList.add("Amount");
            optionsList.add("Free");
        } else if (position == Const.TAG_LOCATION_IDENTITY) {
            optionsList.clear();
            optionsList.add("Address");
            optionsList.add("Room Number");
        } else if (position == Const.TAG_TEACHER_IDENTITY) {
            optionsList.clear();
            optionsList.add("Name");
            optionsList.add("Add a teacher");
        }
        notifyDataSetChanged();
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_answer, parent, false);
        AnswerRecyclerAdapter.AnswerViewHolder answerViewHolder = new AnswerRecyclerAdapter.AnswerViewHolder(view);
        this.viewGroup = parent;
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        holder.eTextView.setText(optionsList.get(position));
        holder.eTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EventsExploreActivity) context).incrementPosition();
            }
        });
        AnimationUtils.recyclerViewAnimation(holder);
    }

    @Override
    public int getItemCount() {
        if (!optionsList.isEmpty()) {
            return optionsList.size();
        }
        return 0;
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder {
        private ETextView eTextView;

        public AnswerViewHolder(View itemView) {
            super(itemView);
            eTextView = (ETextView) itemView.findViewById(R.id.optionsAnswersLayout);
        }
    }
}
