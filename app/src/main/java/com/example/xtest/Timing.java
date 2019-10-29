package com.example.xtest;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class Timing extends AsyncTask<Boolean, Void, Void> {


    @Override
    protected Void doInBackground(Boolean... booleans) {
        try {
            Log.e("MYAPP", "Прошёл");
            Thread.sleep(20000);
            Q.checkin = 0;
            Q.checkauth = true;
            Log.e("Ограничения сняты", "ВСЁ РАБОТАЕТ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
