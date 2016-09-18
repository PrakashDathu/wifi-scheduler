package com.example.saikumar.timepicker;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saikumar on 4/11/2016.
 */
public class AlarmReciever extends BroadcastReceiver{
    public void onReceive(final Context context, Intent intent)
    {
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);


    }
}

