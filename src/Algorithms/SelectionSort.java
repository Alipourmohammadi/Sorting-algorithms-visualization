package Algorithms;

import java.awt.Color;

public class SelectionSort implements ISort {
  public int[] sort(int[] input) {
    int index;
    for (int i = 0; i < input.length; i++) {
      index = i;
      for (int j = i; j < input.length; j++) {
        if (input[j] < input[index]) {
          index = j;
        }
      }
      int temp = input[index];
      input[index] = input[i];
      input[i] = temp;
    }
    return input;
  }

  @Override
  public Color getColor() {
    return Color.green;
  }

  @Override
  public int[] showSort(int[] input) {
    Data.Data.panel.DrawName(this.getClass().getName());

    ISort.show(input);
    int index;
    for (int i = 0; i < input.length; i++) {
      index = i;
      for (int j = i; j < input.length; j++) {
        if (input[j] < input[index]) {
          index = j;
        }
      }
      int temp = input[index];
      input[index] = input[i];
      input[i] = temp;
      // show updated data
      ISort.show(input, new int[] { index, i }, new Color[] { Color.blue, Color.blue });
      ISort.delay(input.length / 5);
    }
    return input;
  }
}