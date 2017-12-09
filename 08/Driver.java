import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    ArrayList<String> instructions = new ArrayList<>();
    while (in.hasNextLine()) {
      instructions.add(in.nextLine());
    }
    System.out.println(Register.findLargestRegister(instructions));
  }
}
