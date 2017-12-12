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
    String[] nums = origin.substring(origin.indexOf("<->") + 4).split(", ");
    for (String s : nums) {
      markThrough(programs, pipes, Integer.parseInt(s));
    }
  }
}
