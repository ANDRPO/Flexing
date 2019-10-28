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

import com.example.xtest.generic.Login_F;

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

                Map<String,String> map = new HashMap<>();
                map.put("login", login);
                map.put("name", name);
                map.put("password", password);

                Network.getInstance().getApi().registrationAPI(map).enqueue(new Callback<ServerResponce<Login_F>>() {
                    @Override
                    public void onResponse(Call<ServerResponce<Login_F>> call, Response<ServerResponce<Login_F>> response) {
                        try {
                            Log.e("MYAPP", response.body().data.getName());
                            Log.e("MYAPP", response.body().data.getRegister_date());
                            Log.e("check", response.body().data.getFull_name().toString());
                            Log.e("MYAPP", response.body().data.settings.getLanguage());
                            Log.e("MYAPP", response.body().data.getToken());
                        }catch (Exception e){
                            Log.e("err", e.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ServerResponce<Login_F>> call, Throwable t) {

                    }
                });
            }
        });
    }
}
