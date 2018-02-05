/*
 * Created by Inan And Akbar
 * Updated by Muhammad Iqbal on 2018. All Rights reserved
 * Last modified 05/02/18 22:08
 */

package com.tamboraagungmakmur.adsplus.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.tamboraagungmakmur.adsplus.MainActivity;
import com.tamboraagungmakmur.adsplus.R;
import com.tamboraagungmakmur.adsplus.config.App;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getSharedPreferences(App.SIGN_IN, 0);
                boolean isLogin = sharedPreferences.getBoolean(App.IS_LOGGED_IN, false);
                if (isLogin) {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
            }
        };

        handler.postDelayed(runnable, 2000);
    }

    @Override
    public void onDestroy() {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    @Override
    public void onPause() {
        finish();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        super.onPause();
    }
}
