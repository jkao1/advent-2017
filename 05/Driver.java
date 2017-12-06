import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    ArrayList<Integer> instructions = new ArrayList<>();
    while (in.hasNextInt()) {
      
      instructions.add(in.nextInt());
    }
    System.out.println(Maze.countSteps(instructions));
  }
}
