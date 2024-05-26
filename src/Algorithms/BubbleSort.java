package Algorithms;

import java.awt.Color;

public class BubbleSort implements ISort {
  // BubbleSort implementation
  public int[] sort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input.length - i - 1; j++) {
        if (input[j] > input[j + 1]) {
          int temp = input[j];
          input[j] = input[j + 1];
          input[j + 1] = temp;
        }
      }
    }
    return input;
  }

  public int[] showSort(int[] input) {
    Data.Data.panel.DrawName(this.getClass().getName());
    ISort.show(input);
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input.length - i - 1; j++) {
        if (input[j] > input[j + 1]) {
          // show and color swapping indexes
          ISort.show(input, new int[] { j, j + 1 }, new Color[] { Color.red.darker(), Color.red.darker() });
          ISort.delay(input.length / 30);
          int temp = input[j];
          input[j] = input[j + 1];
          input[j + 1] = temp;
        }
      }
    }
    ISort.show(input);
    return input;
  }

  // Color representative of the Sort
  @Override
  public Color getColor() {
    return Color.BLUE;
  }
}