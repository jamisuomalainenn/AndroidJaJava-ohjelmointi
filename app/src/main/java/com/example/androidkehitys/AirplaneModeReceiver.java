package com.example.androidkehitys;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Context;
import android.provider.Settings;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // throw new UnsupportedOperationException("Not yet implemented");
        boolean state = intent.getBooleanExtra("state", false);
    }
}