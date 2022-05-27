package com.example.notepadpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 6000;
    ImageView img;
    TextView app_name_intro;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        app_name_intro = findViewById(R.id.app_name_intro);
        lottie = findViewById(R.id.lottie);

        img.animate().translationX(-40000).setDuration(1000).setStartDelay(5000);
        app_name_intro.animate().translationY(2000).setDuration(1000).setStartDelay(5000);
        lottie.animate().translationY(2000).setDuration(1000).setStartDelay(5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                        finish();
            }
        }, SPLASH_SCREEN );
    }
}