package com.example.saikumar.timepicker;

import java.util.*;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {
    private TimePicker timePicker1;
    private TextView time;
    private String format = "";
    private int hour;
    private int min;
    private Timer t;
    private DatePicker datePicker;
    private int dod;
    private int dom;
    private int doy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.textView1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    public void startMethod(View v) {
        hour = timePicker1.getCurrentHour();
        min = timePicker1.getCurrentMinute();
        dod=datePicker.getDayOfMonth();
        dom=datePicker.getMonth();
        doy=datePicker.getYear();
        Calendar c=Calendar.getInstance();
        c.set(doy,dom,dod,hour,min,00);
        /*
        timerTask = new TimerTask() {
            public void run() {
                WifiManager wifiManager = (WifiManager) getBaseContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        };
        t.schedule(timerTask,calendar.getTime());
        */
        Intent intentAlarm = new Intent(this,AlarmReciever.class);
        AlarmManager a = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        a.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}