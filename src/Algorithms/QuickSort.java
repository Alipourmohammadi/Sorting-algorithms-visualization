package Algorithms;

import java.awt.Color;
import java.util.Random;

public class QuickSort implements ISort {
  // Sort implementation
  public int[] sort(int[] arr) {
    return quickSort(arr, 0, arr.length - 1);
  }

  private static int[] quickSort(int[] arr, int low, int high) {
    if (low >= high) {
      return arr;
    }
    int pivot = new Random().nextInt(high - low) + low;
    swap(arr, high, pivot);
    int index = Partition(arr, low, high);
    quickSort(arr, low, index - 1);
    quickSort(arr, index + 1, high);
    return arr;
  }

  private static int Partition(int[] arr, int low, int high) {
    int j = low - 1;
    int pivot = arr[high];
    for (int i = low; i < high; i++) {
      if (arr[i] < pivot) {
        swap(arr, ++j, i);
      }
    }
    swap(arr, high, j + 1);
    return j + 1;
  }

  // partition method + showing the data
  private static int showPartition(int[] arr, int low, int high) {
    int j = low - 1;
    int pivot = arr[high];
    for (int i = low; i < high; i++) {
      if (arr[i] < pivot) {
        swap(arr, ++j, i);
        ISort.show(arr, new int[] { j, i, high }, new Color[] { Color.blue, Color.blue, Color.orange });
        ISort.delay(arr.length / 10);
      }
    }
    swap(arr, high, j + 1);
    ISort.show(arr, new int[] { high, j + 1 }, new Color[] { Color.orange, Color.orange.darker() });
    ISort.delay(arr.length / 20);
    return j + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  @Override
  public Color getColor() {
    return Color.RED;
  }

  @Override
  public int[] showSort(int[] arr) {
    Data.Data.panel.DrawName(this.getClass().getName());

    ISort.show(arr);
    return showQuickSort(arr, 0, arr.length - 1);
  }

  private int[] showQuickSort(int[] arr, int low, int high) {
    if (low >= high) {
      return arr;
    }
    int pivot = new Random().nextInt(high - low) + low;
    // show new selected pivot point
    ISort.show(arr, new int[] { high + 1 != arr.length ? high + 1 : high, pivot },
        new Color[] { Color.orange.darker(), Color.red });
    ISort.delay(arr.length / 30);
    swap(arr, high, pivot);
    int index = showPartition(arr, low, high);
    showQuickSort(arr, low, index - 1);
    showQuickSort(arr, index + 1, high);
    return arr;
  }
}
