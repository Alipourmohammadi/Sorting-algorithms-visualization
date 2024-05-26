public class MakeData {

  public static int[] GenerateRandom(int count, int from, int to) {
    int[] results = new int[count];
    int MFactor = to - from;
    for (int i = 0; i < results.length; i++) {
      results[i] = (int) (Math.random() * (MFactor) + from);
    }
    return results;
  }

}
