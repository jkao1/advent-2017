import java.util.*;


public class Maze {
  public static int countSteps(ArrayList<Integer> instructions)
  {
    nt i, steps;
    i = steps = 0;
    while (i < instructions.size()) {
      if (instructions.get(i) >= 3) {
	instructions.set(i, instructions.get(i) - 1);
	i += instructions.get(i) + 1;
      } else {
	instructions.set(i, instructions.get(i) + 1);
	i += instructions.get(i) - 1;
      }
      steps++;
    }
    return steps;
  }
}
