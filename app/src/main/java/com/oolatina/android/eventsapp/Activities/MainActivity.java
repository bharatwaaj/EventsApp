package com.oolatina.android.eventsapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oolatina.android.eventsapp.Adapters.CardTileRecyclerViewAdapter;
import com.oolatina.android.eventsapp.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardTileRecyclerViewAdapter cardTileRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.eventsRecyclerView);
        cardTileRecyclerViewAdapter = new CardTileRecyclerViewAdapter(getApplicationContext());
        recyclerView.setAdapter(cardTileRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
