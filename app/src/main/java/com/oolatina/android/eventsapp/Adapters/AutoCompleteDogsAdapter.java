package com.oolatina.android.eventsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.oolatina.android.eventsapp.Filters.UsersFilter;
import com.oolatina.android.eventsapp.Models.Users;
import com.oolatina.android.eventsapp.R;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteDogsAdapter extends ArrayAdapter<Users> {

    private final List<Users> userses;
    public List<Users> filteredUserses = new ArrayList<>();

    public AutoCompleteDogsAdapter(Context context, List<Users> userses) {
        super(context, 0, userses);
        this.userses = userses;
    }

    @Override
    public int getCount() {
        return filteredUserses.size();
    }

    @Override
    public Filter getFilter() {
        return new UsersFilter(this, userses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item from filtered list.
        Users users = filteredUserses.get(position);

        // Inflate your custom row layout as usual.
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.layout_teacher_names, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.teacherName);
        TextView tvUid = (TextView) convertView.findViewById(R.id.teacherUid);
        tvName.setText(users.name);
        tvUid.setText(users.uid);

        return convertView;
    }
}