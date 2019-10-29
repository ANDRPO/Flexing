package com.example.xtest.generic;

public class Setting {
    public String language;
    public Boolean push_news;
    public Boolean push_competition;
    public Boolean push_competition_result;

    public Setting(String language, Boolean push_news, Boolean push_competition, Boolean push_competition_result) {
        this.language = language;
        this.push_news = push_news;
        this.push_competition = push_competition;
        this.push_competition_result = push_competition_result;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getPush_news() {
        return push_news;
    }

    public Boolean getPush_competition() {
        return push_competition;
    }

    public Boolean getPush_competition_result() {
        return push_competition_result;
    }
}
