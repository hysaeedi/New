package com.hysaeedi.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button addres, viewres, searchres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addres = (Button) findViewById(R.id.newresultbt);
        viewres = (Button) findViewById(R.id.resviewbt);
        searchres = (Button) findViewById(R.id.ressearchbt);

        addres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentadd = new Intent(MainActivity.this, AddResultActivity.class);
                startActivity(intentadd);
            }
        });

        viewres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentview = new Intent(MainActivity.this, ResultListActivity.class);
                startActivity(intentview);
            }
        });

        searchres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intentsearch);
            }
        });
    }
}

