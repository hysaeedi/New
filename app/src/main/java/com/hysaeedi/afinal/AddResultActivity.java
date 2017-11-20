package com.hysaeedi.afinal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddResultActivity extends Activity {

    Button addnewres;
    EditText team1title, team2title, team1goals, team2goals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        addnewres = (Button) findViewById(R.id.addbt);
        team1title = (EditText) findViewById(R.id.title1bt);
        team2title = (EditText) findViewById(R.id.title2bt);
        team1goals = (EditText) findViewById(R.id.goals1bt);
        team2goals = (EditText) findViewById(R.id.goals2bt);

        addnewres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchResultAdapter adapter = new MatchResultAdapter(AddResultActivity.this);
                MatchResult matchResult = new MatchResult(
                        team1title.getText().toString(),
                        team2title.getText().toString(),
                        Integer.valueOf(team1goals.getText().toString()),
                        Integer.valueOf(team2goals.getText().toString()));

                if (adapter.insert(matchResult)) {
                    Toast.makeText(AddResultActivity.this, "new Result added!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddResultActivity.this, "WRONG! plz check boxes...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
