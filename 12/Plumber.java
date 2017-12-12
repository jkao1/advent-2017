import java.util.*;

public class Plumber {
  public static int findPipesToZero(ArrayList<String> pipes) {
    boolean[] programs = new boolean[2000];
    int groups = 0;
    for (int i = 0; i < programs.length; i++) {
      if (programs[i]) {
        continue;
      }
      markThrough(programs, pipes, i);
      groups++;
    }
    return groups;
  }

  private static void markThrough(boolean[] programs, ArrayList<String> pipes, int index) {
    if (programs[index]) {
      return;
    }
    String origin = pipes.get(index);
    programs[index] = true;
    String[] nums = origin.substring(origin.indexOf("<->") +  4).split(", ");
    for (String s : nums) {
      markThrough(programs, pipes, Integer.parseInt(s));
    }
  }

  private static void printlnBln(boolean[] ary) {
    if (ary.length == 0) {
      System.out.println("[]");
      return;
    }
    String output = "[";
    for (boolean b : ary) {
      output += b + ", ";
    }
    System.out.println(output.substring(0, output.length() -2) + "]");
  }
}
