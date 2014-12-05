package com.contenidos_digitales.spotialarm;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends Activity {

    // Duracion del plash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Seteamos la orientacion Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Ocultamos el title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Seteamos el Layout
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Abrimos un nuevo Activity
                Intent intentMain = new Intent().setClass(SplashActivity.this, MainActivity.class);
                startActivity(intentMain);
                // Cerramos el Activity y lo borramos del historial para que no se pueda volver.
                finish();
            }
        };
        // Simulamos el proceso de carga.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
