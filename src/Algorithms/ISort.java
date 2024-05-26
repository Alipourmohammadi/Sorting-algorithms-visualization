package Algorithms;

import java.awt.Color;

public interface ISort {
  public Color getColor();

  public int[] sort(int[] arr);

  public int[] showSort(int[] arr);

  public static void delay(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
    }
  }

  // get the points with colors which will be shown in different colors
  public static void show(int[] input, int[] points, Color[] colors) {
    Data.Data.panel.drawArray(input, points, colors);
  }

  // show all array in one color
  public static void show(int[] input) {
    Data.Data.panel.drawArray(input, null, null);
  }
}
