package com.example.xtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdmin extends AppCompatActivity {

    Button beg_vremya, beg_vinoslivost, vipadi, otzimaniya, planka, prisyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        beg_vremya = findViewById(R.id.menu_admin_beg_na_vremya);
        beg_vinoslivost = findViewById(R.id.menu_admin_beg_na_vinoslivost);
        vipadi = findViewById(R.id.menu_admin_vipadi);
        otzimaniya = findViewById(R.id.menu_admin_otzimania);
        planka = findViewById(R.id.menu_admin_planka);
        prisyad = findViewById(R.id.menu_admin_prisedaniya);

        beg_vremya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, Parameters.class);
                intent.putExtra("nameing", beg_vremya.getText().toString());
                startActivity(intent);
            }
        });

        beg_vinoslivost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, Parameters.class);
                intent.putExtra("nameing", beg_vinoslivost.getText().toString());
                startActivity(intent);
            }
        });

        vipadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, Parameters.class);
                intent.putExtra("nameing", vipadi.getText().toString());
                startActivity(intent);
            }
        });

        otzimaniya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, Parameters.class);
                intent.putExtra("nameing", otzimaniya.getText().toString());
                startActivity(intent);
            }
        });

        planka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, Parameters.class);
                intent.putExtra("nameing", planka.getText().toString());
                startActivity(intent);
            }
        });

        prisyad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, Parameters.class);
                intent.putExtra("nameing", prisyad.getText().toString());
                startActivity(intent);
            }
        });
    }
}
