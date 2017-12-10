import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    ArrayList<Integer> lengths = new ArrayList<>();
    for (char c : in.nextLine().toCharArray()) {
      lengths.add((int) c);
    }
    lengths.add(17);
    lengths.add(31);
    lengths.add(73);
    lengths.add(47);
    lengths.add(23);
    System.out.println(KnotHash.sparseHash(lenghts));
  }
}
