package com.example.xtest;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registrion_users extends AppCompatActivity {

    private Button reg_user_out;
    private EditText et_login, et_name, et_pass;
    private String login, name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrion_users);
        reg_user_out = findViewById(R.id.b_reg_user_out);

        et_login = findViewById(R.id.et_registration_login);
        et_name = findViewById(R.id.et_registration_name);
        et_pass = findViewById(R.id.et_registration_password);

        reg_user_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = et_login.getText().toString();
                name = et_name.getText().toString();
                password = et_pass.getText().toString();

//                Log.e("ZAPROS OUT", JO);
//
//                Network.getInstance().getApi().registrationAPI(JO).enqueue(new Callback<JsonElement>() {
//                    @Override
//                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
//                        Log.e("URRRRRAAAAA" , response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<JsonElement> call, Throwable t) {
//                        Log.e("URRRRRAAAAA" , t.toString());
//                    }
//                });

            }
        });
    }
}
