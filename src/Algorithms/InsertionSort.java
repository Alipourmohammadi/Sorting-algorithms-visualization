package Algorithms;

import java.awt.Color;

public class InsertionSort implements ISort {
  // implementation of sort
  public int[] sort(int[] input) {
    int p, value;
    for (int i = 1; i < input.length; i++) {
      value = input[i];
      p = i - 1;
      while (p >= 0 && input[p] > value) {
        input[p + 1] = input[p];
        p--;
      }
      input[p + 1] = value;
    }
    return input;
  }

  // color representative of sort
  @Override
  public Color getColor() {
    return Color.YELLOW;
  }

  @Override
  public int[] showSort(int[] input) {
    Data.Data.panel.DrawName(this.getClass().getName());

    int p, value;
    ISort.show(input);
    for (int i = 1; i < input.length; i++) {
      value = input[i];
      p = i - 1;
      while (p >= 0 && input[p] > value) {
        input[p + 1] = input[p];
        // show and color swapping indexes
        ISort.show(input, new int[] { p, p + 1 }, new Color[] { Color.blue, Color.blue });
        ISort.delay(input.length / 30);
        p--;
      }
      input[p + 1] = value;
      ISort.show(input);
    }
    return input;
  }
}