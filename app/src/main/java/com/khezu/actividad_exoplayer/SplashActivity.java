package com.khezu.actividad_exoplayer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private com.mikhaellopez.circularfillableloaders.CircularFillableLoaders avatar;
    private ImageView nota1, nota2, nota3, nota4;
    CountDownTimer contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        avatar = (com.mikhaellopez.circularfillableloaders.CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
        nota1 = (ImageView) findViewById(R.id.nota1);
        nota2 = (ImageView) findViewById(R.id.nota2);
        nota3 = (ImageView) findViewById(R.id.nota3);
        nota4 = (ImageView) findViewById(R.id.nota4);

        Animation animacion_avatar = AnimationUtils.loadAnimation(this, R.anim.anim_splash_avatar);
        Animation animacion_nota1 = AnimationUtils.loadAnimation(this, R.anim.anim_splash_1);
        Animation animacion_nota2 = AnimationUtils.loadAnimation(this, R.anim.anim_splash_2);
        Animation animacion_nota3 = AnimationUtils.loadAnimation(this, R.anim.anim_splash_3);
        Animation animacion_nota4 = AnimationUtils.loadAnimation(this, R.anim.anim_splash_4);

        avatar.startAnimation(animacion_avatar);
        nota1.startAnimation(animacion_nota1);
        nota2.startAnimation(animacion_nota2);
        nota3.startAnimation(animacion_nota3);
        nota4.startAnimation(animacion_nota4);

        contador = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, SeleccionActivity.class);
                startActivity(intent);
                finish();
            }
        };

        contador.start();
    }
}
