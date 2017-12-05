import java.util.*;


public class Maze {
		public static int countSteps(ArrayList<Integer> instructions)
		{
				int i, steps;
				i = steps = 0;
				while (i < instructions.size()) {
						instructions.set(i, instructions.get(i) + 1);
						i += instructions.get(i) - 1;
						steps++;
				}
				return steps;
		}
}
