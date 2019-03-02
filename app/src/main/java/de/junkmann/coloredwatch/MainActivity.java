package de.junkmann.coloredwatch;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wear.widget.BoxInsetLayout;
import android.support.wearable.activity.WearableActivity;

public class MainActivity extends WearableActivity {

  private ValueAnimator colorAnim;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BoxInsetLayout parentLayout = findViewById(R.id.parentLayout);

    setAmbientEnabled();

    parentLayout.setBackgroundColor(Color.RED);

    colorAnim = ObjectAnimator.ofInt(parentLayout, "backgroundColor", Color.RED, Color.rgb(255, 0, 1));

    colorAnim.setDuration(20000);
    colorAnim.setEvaluator(new HsvEvaluator());
    colorAnim.setRepeatCount(ValueAnimator.INFINITE);
    colorAnim.start();
  }

  @Override
  protected void onStop() {
    super.onStop();
    colorAnim.end();
  }
}




