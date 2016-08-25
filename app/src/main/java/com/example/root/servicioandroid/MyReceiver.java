package com.example.root.servicioandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent s = new Intent(context, MyIntentService.class);
        context.startService(s);
    }
}
