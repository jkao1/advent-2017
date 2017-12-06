import java.util.*;
import java.io*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    ArrayList<Integer> bank = new ArrayList<>();
    while (in.hasNextInt()) {
      bank.add(in.nextInt());
    }
    System.out.println(Memory.redistribute(bank));
  }
}
