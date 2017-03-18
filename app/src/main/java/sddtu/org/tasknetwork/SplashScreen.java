package sddtu.org.tasknetwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.AccessibleObject;

/**
 * Created by ASHISH KUMAR on 3/15/2017.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    Intent intent=new Intent(SplashScreen.this,CustomerSPActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.start();

    }
}
