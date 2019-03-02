/*
Found on http://cogitolearning.co.uk/2014/01/android-property-animations-evaluators/ and the corresponding github repo:
https://github.com/mikailsheikh/cogitolearning-examples/blob/master/PropertyAnimations/src/uk/co/cogitolearning/propertyanimations_example/HsvEvaluator.java
 */

package de.junkmann.coloredwatch;

import android.animation.TypeEvaluator;
import android.graphics.Color;

public class HsvEvaluator implements TypeEvaluator<Integer> {
  public Integer evaluate(float fraction,
      Integer startValue,
      Integer endValue) {
    float[] startHsv = new float[3];
    float[] endHsv = new float[3];
    float[] currentHsv = new float[3];

    Color.colorToHSV(startValue, startHsv);
    Color.colorToHSV(endValue, endHsv);

    for (int i=0; i<3; i++)
      currentHsv[i] = (1-fraction)*startHsv[i] + fraction*endHsv[i];

    while (currentHsv[0]>=360.0f) currentHsv[0] -= 360.0f;
    while (currentHsv[0]<0.0f) currentHsv[0] += 360.0f;

    return Color.HSVToColor(currentHsv);
  }
}