package com.example.xtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Timing extends AsyncTask<Context, Void, Void> {


    @Override
    protected Void doInBackground(Context... contexts) {
        try {
            Log.e("MYAPP", "Прошёл");
            Thread.sleep(20000);
            Q.checkin = 0;
            Q.checkauth = true;
            Log.e("Ограничения сняты", "ВСЁ РАБОТАЕТ");
            // Sets an ID for the notification, so it can be updated.
            int notifyID = 1;
            String CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence name = "channel_01";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
// Create a notification and set the notification channel.
            Notification notification = new NotificationCompat.Builder(contexts[0])
                    .setContentTitle("По поводу бана")
                    .setContentText("Ограничения сняты, вы можете повторить вход.")
                    .setSmallIcon(R.mipmap.image_unbanned)
                    .setChannelId(CHANNEL_ID)
                    .build();
            NotificationManager mNotificationManager = (NotificationManager) contexts[0].getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(mChannel);

// Issue the notification.
            mNotificationManager.notify(notifyID, notification);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
