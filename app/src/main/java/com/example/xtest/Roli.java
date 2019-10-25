package com.example.xtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Roli extends AppCompatActivity {

    Button admin, client, trener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roli);

        admin = findViewById(R.id.b_rol_admin);
        trener = findViewById(R.id.b_rol_trener);
        client = findViewById(R.id.b_rol_client);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Roli.this, MenuAdmin.class));
                finish();
            }
        });

        trener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Roli.this, MenuTrener.class));
                finish();
            }
        });

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Roli.this, MenuClient.class));
                finish();
            }
        });
    }
}
