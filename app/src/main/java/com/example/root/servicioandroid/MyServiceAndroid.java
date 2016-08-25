package com.example.root.servicioandroid;

import android.app.IntentService;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;


public class MyServiceAndroid extends IntentService {


    public MyServiceAndroid() {
        super("MyServiceAndroid");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

            String date = (DateFormat.format("dd-MM-yyyy hh:mm:ss", new java.util.Date()).toString());
            Log.i("holaa",date);

    }


}
