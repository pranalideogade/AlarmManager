package com.example.pranali_deogade.alarmmanager;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextClock textClock;
    EditText passWord;

    Date date;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       calendar=Calendar.getInstance();
        textClock=(TextClock)findViewById(R.id.textClock);
        passWord=(EditText)findViewById(R.id.passWord);
         String oldstring = "2017-12-22 13:45:00.0";
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                calendar.setTime(date);

        setAlarm(calendar.getTimeInMillis());
        findViewById(R.id.setAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passWord.getText().toString().equals("Luffy#57")) {
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void setAlarm(long time){
        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(this,MyAlarm.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
        alarmManager.setRepeating(AlarmManager.RTC,time,AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this,"Alarm is set",Toast.LENGTH_LONG).show();

    }
}
