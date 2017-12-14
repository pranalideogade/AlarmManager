package com.example.pranali_deogade.alarmmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pranali_deogade on 11-12-2017.
 */

public class MyAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer mediaPlayer=MediaPlayer.create(context, R.raw.mere);
        mediaPlayer.start();
        Intent i = new Intent(context, AlarmService.class);
        context.startService(i);



    }
}
