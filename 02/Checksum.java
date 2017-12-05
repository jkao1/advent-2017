import java.util.ArrayList;

public class Checksum {
  public static int checksum(ArrayList<int[]> sheet) {
    int output = 0;
    for (int[] ary : sheet) {
      int min, max;
      min = max = ary[0];
      for (int n : ary) {
        if (n < min) {
          min = n;
        }
        if (n > max) {
          max = n;
        }
      }
      output += max - min;
    }
    return output;
  }

  public static int checksumEvenly(ArrayList<int[]> sheet) {
    int output = 0;
    for (int[] ary : sheet) {
      output += checkArrayEvenly(ary);
    }
    return output;
  }

  private static int checkArrayEvenly(int[] ary) {
    for (int i = 0; i < ary.length; i++) {
      for (int j = i + 1; j < ary.length; j++) {
        if (Math.max(ary[i], ary[j]) % Math.min(ary[i], ary[j]) == 0) {
          return Math.max(ary[i], ary[j]) / Math.min(ary[i], ary[j]);
        }
      }
    }
    return 0;
  }
}
