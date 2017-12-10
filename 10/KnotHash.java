import java.util.*;

public class KnotHash {
  public static int findProduct(ArrayList<Integer> lengths) {
    ArrayList<Integer> list = generateList();
    int current, skip;
    current = skip = 0;

    for (int length : lengths) {
      reverseSublist(list, current, current + length);
      current = (current + length + skip) % list.size();
      skip++;
    }

    return list.get(0) * list.get(1);
  }

  public static String toKnotHash(ArrayList<Integer> lengths) {
    return toHexadecimal(denseHash(sparseHash(lengths)));
  }

  private static ArrayList<Integer> sparseHash(ArrayList<Integer> lengths)
  {
    ArrayList<Integer> list = generateList();
    int current, skip;
    current = skip = 0;

    for (int i = 0; i < 64; i++) {
      for (int length : lengths) {
        reverseSublist(list, current, current + length);
        current = (current + length + skip) % list.size();
        skip++;
      }
    }

    return list;
  }

  private static ArrayList<Integer> denseHash(ArrayList<Integer> list)
  {
    ArrayList<Integer> denseNumbers = new ArrayList<>();
    for (int i = 0; i < list.size(); i += 16) {
      int denseNum = list.get(i);
      for (int j = i + 1; j < i + 16; j++) {
        denseNum ^= list.get(j);
      }
      denseNumbers.add(denseNum);
    }
    return denseNumbers;
  }

  private static String toHexadecimal(ArrayList<Integer> list)
  {
    String output = "";
    for (int x : list) {
      String hexString = Integer.toHexString(x);
      if (hexString.length() == 1) {
        hexString = "0" + hexString;
      }
      output += hexString;
    }
    return output;
  }

  private static void reverseSublist(ArrayList list, int start, int end)
  {
    end--; // function reverses in the interval [start, end)
    while (start < end) {
      swap(list, start % list.size(), end % list.size());
      start++;
      end--;
    }
  }

  private static void swap(ArrayList<Integer> list, int a, int b) {
    int temp = list.get(b);
    list.set(b, list.get(a));
    list.set(a, temp);
  }

  private static ArrayList<Integer> generateList() {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 256; i++) {
      list.add(i);
    }
    return list;
  }
}
