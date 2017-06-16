package com.oolatina.android.eventsapp.Filters;

import android.widget.Filter;

import com.oolatina.android.eventsapp.Adapters.AutoCompleteDogsAdapter;
import com.oolatina.android.eventsapp.Models.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersFilter extends Filter {

    AutoCompleteDogsAdapter adapter;
    List<Users> originalList;
    List<Users> filteredList;

    public UsersFilter(AutoCompleteDogsAdapter adapter, List<Users> originalList) {
        super();
        this.adapter = adapter;
        this.originalList = originalList;
        this.filteredList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        filteredList.clear();
        final FilterResults results = new FilterResults();

        if (constraint == null || constraint.length() == 0) {
            filteredList.addAll(originalList);
        } else {
            final String filterPattern = constraint.toString().toLowerCase().trim();

            // Your filtering logic goes in here
            for (final Users users : originalList) {
                if (users.name.toLowerCase().contains(filterPattern)) {
                    filteredList.add(users);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.filteredUserses.clear();
        adapter.filteredUserses.addAll((List) results.values);
        adapter.notifyDataSetChanged();
    }
}