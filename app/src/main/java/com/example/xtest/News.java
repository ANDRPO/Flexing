package com.example.xtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.xtest.GettersAndSetters.GAS_news;
import com.example.xtest.adapters.CA_news;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News extends AppCompatActivity {

    public EditText et_search;
    public Button b_search;
    public String baldesh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        b_search = findViewById(R.id.news_b_search);
        et_search = findViewById(R.id.news_et_search);

        Network.getInstance().getApi().newsAPI().enqueue(new Callback<ServerResponce<ArrayList<GAS_news>>>() {
            @Override
            public void onResponse(Call<ServerResponce<ArrayList<GAS_news>>> call, Response<ServerResponce<ArrayList<GAS_news>>> response) {

                ListView listView = findViewById(R.id.news_lv_listView);
                Q.gasNews.addAll(response.body().data);
                CA_news ca_news = new CA_news(getApplicationContext(),R.layout.item_list_news, Q.gasNews);
                listView.setAdapter(ca_news);

            }

            @Override
            public void onFailure(Call<ServerResponce<ArrayList<GAS_news>>> call, Throwable t) {

            }
        });

        b_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baldesh = et_search.getText().toString();
                List<GAS_news> cloneList = new ArrayList<>();
                for(GAS_news news : Q.gasNews){
                    if (news.getTitle().contains(baldesh)) {
                        cloneList.add(news);
                    }
                }
                ListView listView = findViewById(R.id.news_lv_listView);
                CA_news ca_news = new CA_news(getApplicationContext(),R.layout.item_list_news, cloneList);
                listView.setAdapter(ca_news);


            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<GAS_news> cloneList = new ArrayList<>();
                for(GAS_news news : Q.gasNews){
                    if (news.getTitle().contains(s.toString())) {
                        cloneList.add(news);
                    }
                }
                ListView listView = findViewById(R.id.news_lv_listView);
                CA_news ca_news = new CA_news(getApplicationContext(),R.layout.item_list_news, cloneList);
                listView.setAdapter(ca_news);
            }
        });

    }
}
