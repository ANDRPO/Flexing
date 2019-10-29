package com.example.xtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xtest.generic.Login_F;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Auth extends AppCompatActivity {

    private Button b_in_auth, b_registration_auth;
    private EditText et_login_auth, et_password_auth;
    private String login, password;
    final int limitation = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);


        b_in_auth = findViewById(R.id.b_in_auth);
        b_registration_auth = findViewById(R.id.b_registration_auth);

        et_login_auth = findViewById(R.id.et_login_auth);
        et_password_auth = findViewById(R.id.et_password_auth);

        b_in_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = et_login_auth.getText().toString();
                password = et_password_auth.getText().toString();
                Log.e("SUCCESS", login);
                Log.e("SUCCESS", password);
                Log.e("SUCCESS", "SUCCESS");

                Network.getInstance().getApi().authAPI(login, password).enqueue(new Callback<ServerResponce<Login_F>>() {
                    @Override
                    public void onResponse(Call<ServerResponce<Login_F>> call, Response<ServerResponce<Login_F>> response) {
                        try {
                            Log.e("CHECK", String.valueOf(Q.checkin));
                            Log.e("SUCCESS", response.body().getSuccess().toString());

                            if(Q.checkauth){
                                Q.checkin = 0;
                            }
                            if (response.body().data.token != null && Q.checkin <= 3) {
                                Q.token = response.body().data.getToken();
                                startActivity(new Intent(getApplicationContext(), News.class));
                            }
                            else {
                                Q.checkin++;
                                Toast.makeText(getApplicationContext(), "Ошибка авторизации", Toast.LENGTH_SHORT).show();
                                if(Q.checkin == 1) {
                                    Timing timing = new Timing();
                                    Q.checkauth = false;
                                    timing.execute(false);
                                }
                                if(Q.checkin > 3)
                                    Toast.makeText(getApplicationContext(), "Вы забанены и обязаны ждать", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ServerResponce<Login_F>> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                    }
                });

            }
        });

        b_registration_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Auth.this, Registrion_users.class));
            }
        });
    }
}

// "data": {
//        "id": "24e40dd5-4e66-55bb-caa5-3a9767445cf1",
//        "login": "andrpol",
//        "name": "Andrewik",
//        "surname": "",
//        "full_name": "",
//        "bonus_count": "40",
//        "win_count": 1,
//        "competitions": 4,
//        "quiz": 2,
//        "register_date": "2019-10-25 07:10:17.000000 +0300",
//        "image": "http://dev.hakta.pro/o/silkway/uploads/files/user_no_avatar-min.jpg",
//        "settings": {
//            "language": "ru",
//            "push_news": true,
//            "push_competition": false,
//            "push_competition_result": false
//        },
//        "token": "09e98c48-bf6e-e04e-39db-81e29d4f8af2"
//    },
//    "success": true
