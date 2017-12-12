import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String[] directions = in.nextLine().split(",");
    System.out.println(Hex.findFewestSteps(directions));
  }
}
