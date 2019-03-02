package de.junkmann.coloredwatch;

import android.graphics.Color;
import android.os.Bundle;
import android.support.wear.widget.BoxInsetLayout;
import android.support.wearable.activity.WearableActivity;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends WearableActivity {

  private BoxInsetLayout parentLayout;
  private Timer timer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    parentLayout = findViewById(R.id.parentLayout);

    setAmbientEnabled();

    parentLayout.setBackgroundColor(Color.RED);

    timer = new Timer();



    MyTimerTask myTimerTask = new MyTimerTask();
    //schedule to change background color every second
    timer.schedule(myTimerTask, 1000, 1000);


  }

  @Override
  protected void onStop() {
    super.onStop();
    timer.cancel();
  }


  class MyTimerTask extends TimerTask {

    @Override
    public void run() {
      //Since we want to change something which is on hte UI
      //so we have to run on UI thread..
      runOnUiThread(new Runnable() {
        @Override
        public void run() {
          Random random = new Random();//this is random generator
          parentLayout.setBackgroundColor(
              Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }
      });
    }
  }
}




