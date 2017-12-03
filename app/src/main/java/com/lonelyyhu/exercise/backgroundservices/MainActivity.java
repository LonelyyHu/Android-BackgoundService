package com.lonelyyhu.exercise.backgroundservices;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_NOTIFICATION = "com.lonelyyhu.exercise.backgroundservices.ACTION_NOTIFICATION";
    public static final int CODE_NOTITY = 100;
    public static final int NOTIFY_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_notify_receiver:
                notifyToReceiver();
                break;
            case R.id.button_start_service:
                startMyService();
                break;
            case R.id.button_stop_service:
                stopMyService();
                break;
            case R.id.button_notify_service:
                notifyToService();
                break;



        }






    }

    private void stopMyService() {

        Intent intent = new Intent(this, MyService.class);
        stopService(intent);

    }

    private void startMyService() {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);


    }

    private void notifyToReceiver() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(ACTION_NOTIFICATION);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, CODE_NOTITY, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Notify")
                .setContentText("Start Receiver")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .build();

        manager.notify(NOTIFY_ID, notification);
    }

    private void notifyToService() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, MyService.class);

        PendingIntent pendingIntent = PendingIntent.getService(this, CODE_NOTITY, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Notify")
                .setContentText("Start Service")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .build();

        manager.notify(NOTIFY_ID, notification);
    }
}
