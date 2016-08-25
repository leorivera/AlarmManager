package com.example.root.servicioandroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!conexionInternet()) {
            Toast.makeText(this, "Verifique su acceso a internet", Toast.LENGTH_SHORT).show();
            return;
        }

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                    alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

                    alarmMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(),
                            1000 * 60 * 1, alarmIntent);

                } catch (Exception e) {

                    Log.i("error",e.getMessage());
                }



                //Intent intent = new Intent(view.getContext(), MyServiceAndroid.class);

                //PendingIntent pendingIntent = PendingIntent.getService(view.getContext(),0,  intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //AlarmManager manager = (AlarmManager) view.getContext().getSystemService(Context.ALARM_SERVICE);
               // manager.set(AlarmManager.RTC, System.currentTimeMillis()+1000, pendingIntent);
                //manager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
               // manager.setInexactRepeating(AlarmManager.RTC, System.currentTimeMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);


                //Intent intent = new Intent(view.getContext(), MyServiceAndroid.class);
                //startService(intent);
            }
        });
    }

    public boolean conexionInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

}
