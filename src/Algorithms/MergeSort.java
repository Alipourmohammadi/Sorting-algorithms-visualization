package Algorithms;

import java.awt.Color;

public class MergeSort implements ISort {
  // Sort implementation
  public int[] sort(int[] input) {
    if (input.length > 1) {
      var n1 = split(input, 0, input.length / 2);
      var n2 = split(input, input.length / 2, input.length - input.length / 2);
      return merge(sort(n1), sort(n2));
    }
    return input;
  }

  public static int[] split(int[] arr, int index, int half) {
    int[] n2 = new int[half];
    for (int i = 0; i < n2.length; i++) {
      n2[i] = arr[index++];
    }
    return n2;
  }

  public static int[] merge(int[] in1, int[] in2) {
    int[] results = new int[in1.length + in2.length];
    int n1Index = 0, n2Index = 0;
    for (int i = 0; i < results.length; i++) {
      if (n2Index > in2.length - 1) {
        results[i] = in1[n1Index++];
        continue;
      }
      if (n1Index > in1.length - 1) {
        results[i] = in2[n2Index++];
        continue;
      }
      if (in1[n1Index] < in2[n2Index]) {
        results[i] = in1[n1Index];
        n1Index++;
      } else {
        results[i] = in2[n2Index];
        n2Index++;
      }
    }
    return results;
  }

  public Color getColor() {
    return Color.orange;
  }

  public int[] showSort(int[] input) {
    Data.Data.panel.DrawName(this.getClass().getName());

    // save the main array to be able to show it
    arr = input;
    // do the sorting
    return DoSort(input, 0, input.length);
  }

  private int[] arr;

  public int[] DoSort(int[] input, int from, int to) {
    ISort.show(arr);
    if (input.length > 1) {
      int half = input.length / 2;
      var n1 = split(input, 0, half);
      var n2 = split(input, half, input.length - half);
      var x = merge(DoSort(n1, from, from + half), DoSort(n2, from + half, to));
      int index = 0;
      int[] temp = new int[to - from];
      Color[] CTemp = new Color[to - from];
      for (int i = from; i < to; i++) {
        CTemp[index] = Color.red;
        temp[index] = i;
        arr[i] = x[index++];
        // show changed values
        ISort.show(arr, new int[] { i }, new Color[] { Color.blue });
        ISort.delay(arr.length / 2);
      }
      // show merged part
      ISort.show(arr, temp, CTemp);
      ISort.delay(arr.length / 2);
      return x;
    }
    return input;
  }
}