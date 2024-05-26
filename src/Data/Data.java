package Data;

import Algorithms.*;
import Panel.MyPanel;

public class Data {
  // recorder time taken
  public static long[] times;
  // panel which graphs are drawn
  public static MyPanel panel;
  // data counts
  public static int[] DataCount = { 1000, 20_000, 100_000 };
  public static int[] DataCountForShow = { 110 };
  // algorithms to do the sorting in order
  public static ISort[] algorithms = { new SelectionSort(), new InsertionSort(), new BubbleSort(), new MergeSort(),
      new QuickSort()
  };
}
