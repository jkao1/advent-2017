import java.util.*;

public class Knot {
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
