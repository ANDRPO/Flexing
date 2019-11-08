package com.example.xtest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.xtest.GettersAndSetters.GAS_news;
import com.example.xtest.MapsActivity;
import com.example.xtest.R;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class CA_news extends ArrayAdapter<GAS_news> {

    private LayoutInflater inflater;
    private int listitemId;
    private List<GAS_news> list;

    public CA_news(@NonNull Context context, int resource, @NonNull List<GAS_news> objects) {
        super(context, resource, objects);
        this.list = objects;
        this.listitemId = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = inflater.inflate(listitemId,parent,false);

        TextView date = v.findViewById(R.id.item_news_date);
        TextView info = v.findViewById(R.id.item_news_information);

        GAS_news gasNews = this.list.get(position);

        date.setText(gasNews.getCreate_date());
        info.setText(gasNews.getTitle());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), MapsActivity.class).setFlags(FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return v;
    }
}
