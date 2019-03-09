package com.example.humberto.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;

public class BatteryCheck extends BroadcastReceiver {

    static final String CHANNEL_ID = "001";
    static final int ID = 1234;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, CHANNEL_ID);
        NotificationManager notificationManager;
        if(action.equals(Intent.ACTION_POWER_CONNECTED)) {

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                    intent, 0);

            mBuilder.setContentIntent(pendingIntent);

            mBuilder.setSmallIcon(R.drawable.battery_icon);
            mBuilder.setContentTitle("Device charging");
            mBuilder.setContentText("The device is plugged and charging");
            mBuilder.setAutoCancel(true);

            notificationManager =
                    (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(ID, mBuilder.build());

        }
    }
}
