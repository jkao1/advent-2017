import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    ArrayList<String> pipes = new ArrayList<>();
    while (in.hasNextLine()) {
      pipes.add(in.nextLine());
    }
    System.out.println(Plumber.findPipesToZero(pipes));
  }
}
