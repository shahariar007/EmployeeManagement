package com.example.n33r.presentationproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class SplashActivity extends Activity {

    ImageView imageView;
    TextView first,second,third;
    Animation animation,animation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        first=(TextView)findViewById(R.id.logosecond);
        Typeface face=Typeface.createFromAsset(getAssets(), "fonts/parkane.ttf");
        first.setTypeface(face);
        imageView=(ImageView)findViewById(R.id.androidlogoanim);
        animation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
         animation1=AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        animation1.setDuration(3000);
        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                YoYo.with(Techniques.ZoomIn).duration(1000).playOn(first);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            imageView.startAnimation(animation1);
                finish();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,R.anim.abc_slide_out_top);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }


}
