package com.oolatina.android.eventsapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.oolatina.android.eventsapp.Adapters.AnswerRecyclerAdapter;
import com.oolatina.android.eventsapp.Adapters.AutoCompleteDogsAdapter;
import com.oolatina.android.eventsapp.Models.Users;
import com.oolatina.android.eventsapp.R;
import com.oolatina.android.eventsapp.Widgets.ETextView;

import java.util.ArrayList;
import java.util.List;

public class EventsExploreActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> questionsStrings = new ArrayList<>();
    private AnswerRecyclerAdapter answerRecyclerAdapter;
    private static int position = 0;

    private ImageView backButton;
    private RecyclerView recyclerView;
    private ETextView eTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_explore);
        initQuestionStrings();
        initUI();
        position = 0;
    }

    private void initQuestionStrings() {
        questionsStrings.add(0,"Which Activity ?");
        questionsStrings.add(1,"Which Style ?");
        questionsStrings.add(2,"Which Level ?");
        questionsStrings.add(3,"which Moment?");
        questionsStrings.add(4,"which Price?");
        questionsStrings.add(5,"which Location?");
        questionsStrings.add(6,"which Teacher?");
    }

    private void initUI() {

        backButton = (ImageView) findViewById(R.id.backActivityEvents);
        recyclerView = (RecyclerView) findViewById(R.id.answersRecyclerView);
        eTextView = (ETextView) findViewById(R.id.questionActivityExplore);
        backButton.setOnClickListener(this);

        answerRecyclerAdapter = new AnswerRecyclerAdapter(this);
        loadQuestion(position);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backActivityEvents:
                triggerPreviousQuestion();
        }
    }

    private void triggerPreviousQuestion() {
        if(position == -1){
            finish();
        }else{
            loadQuestion(position--);
        }
    }

    private void loadQuestion(int i) {
        eTextView.setText(questionsStrings.get(i));
        answerRecyclerAdapter.setOptionsList(i);
        recyclerView.setAdapter(answerRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void incrementPosition() {
        if(position < 5){
            position++;
            loadQuestion(position);
        }else if(position == 5){
            position++;
            placesAutocompleteAction();
        }else if(position == 6){
            position++;
            searchAutocompleteAction();
        }else{
            eTextView.setText("Done!");
            recyclerView.setVisibility(View.GONE);
        }
    }

    public void placesAutocompleteAction(){
        recyclerView.setVisibility(View.GONE);
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("France",""));
        usersList.add(new Users("India",""));
        usersList.add(new Users("United Kinngdom",""));
        AutoCompleteDogsAdapter adapter = new AutoCompleteDogsAdapter(this, usersList);
        AutoCompleteTextView autocompleteView =
                (AutoCompleteTextView) findViewById(R.id.autocompleteView);
        autocompleteView.setVisibility(View.VISIBLE);
        autocompleteView.setAdapter(adapter);
    }

    public void searchAutocompleteAction(){
        recyclerView.setVisibility(View.GONE);
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("Bharat","@bharat"));
        usersList.add(new Users("Fabrice","@fabrice"));
        usersList.add(new Users("Vivek","@vivek"));
        AutoCompleteDogsAdapter adapter = new AutoCompleteDogsAdapter(this, usersList);
        AutoCompleteTextView autocompleteView =
                (AutoCompleteTextView) findViewById(R.id.autocompleteView);
        autocompleteView.setVisibility(View.VISIBLE);
        autocompleteView.setAdapter(adapter);
    }
}
