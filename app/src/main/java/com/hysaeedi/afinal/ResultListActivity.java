package com.hysaeedi.afinal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ResultListActivity extends Activity {

    ListView reslist;
    List<MatchResult> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

        reslist = (ListView) findViewById(R.id.resultlst);

        MatchResultAdapter adapter = new MatchResultAdapter(this);
        resultList = adapter.getAll();

        reslist.setAdapter(new ResListAdapter());
    }

    private class ResListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public MatchResult getItem(int position) {
            return resultList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return resultList.get(position).id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(ResultListActivity.this).inflate(R.layout.results_list_item, parent);
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
