import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    ArrayList<Integer> lengths = new ArrayList<>();
    for (String length : in.nextLine().split(",")) {
      lengths.add(Integer.parseInt(length));
    }
    System.out.println(Knot.findProduct(lengths));
  }
}
