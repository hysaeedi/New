package com.hysaeedi.afinal;

public class MatchResult {

    public MatchResult(String team1title, String team2title, int team1goals, int team2goals) {
        team1title = team1title;
        team2title = team2title;
        team1goals = team1goals;
        team2goals = team2goals;
    }

    public MatchResult() {

    }

    int id;
    String team1title;
    String team2title;
    int team1goals;
    int team2goals;
}
