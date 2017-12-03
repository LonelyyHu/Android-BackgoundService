package com.lonelyyhu.exercise.backgroundservices;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.wtf("MyService", "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.wtf("MyService", "onStartCommand: ");

        new MyTask().execute();

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.wtf("MyService", "onBind: ");

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.wtf("MyService", "onDestroy: ");
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            for (int i = 0; i < 10; i++) {

                Log.wtf("MyTask", "doInBackground: " + i);

                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


            return null;
        }
    }



}
