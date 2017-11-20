package com.hysaeedi.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchActivity extends Activity {

    EditText et_search;
    Button s_search;
    ListView reslstsearch;
    List<MatchResult> lstsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_search = (EditText) findViewById(R.id.searchet);
        s_search = (Button) findViewById(R.id.ssearchbt);
        reslstsearch = (ListView) findViewById(R.id.tvsearchlst);

        s_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchtxt = et_search.getText().toString();
                if (searchtxt.length() < 1) {
                    Toast.makeText(SearchActivity.this, "WRONG! please type correctly...", Toast.LENGTH_SHORT).show();

                } else {
                    MatchResultAdapter adapter = new MatchResultAdapter(SearchActivity.this);
                    lstsearch = adapter.search(searchtxt);
                    reslstsearch.setAdapter(new ResListAdapter());
                }
            }
        });
    }

    private class ResListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return lstsearch.size();
        }

        @Override
        public MatchResult getItem(int position) {
            return lstsearch.get(position);
        }

        @Override
        public long getItemId(int position) {
            return lstsearch.get(position).id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(
                    SearchActivity.this).inflate(R.layout.results_list_item, parent);
            TextView team1title, team2title, team1goals, team2goals;
            team1title = (TextView) v.findViewById(R.id.tvtitle1);
            team2title = (TextView) v.findViewById(R.id.tvtitle2);
            team1goals = (TextView) v.findViewById(R.id.tvgoals1);
            team2goals = (TextView) v.findViewById(R.id.tvgoals2);

            team1title.setText(getItem(position).team1title);
            team2title.setText(getItem(position).team2title);
            team1goals.setText(String.valueOf(getItem(position).team1goals));
            team2goals.setText(String.valueOf(getItem(position).team2goals));

            return v;
        }
    }
}
