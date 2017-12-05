import java.util.*;


public class Maze {
		public static int countSteps(ArrayList<Integer> instructions)
		{
				int i, steps;
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

		public static void printlnInstructions(ArrayList<Integer> instructions, int index)
		{
				String output = "[";
				for (int i = 0; i < instructions.size(); i++) {
						if (i == index) {
								output += "(" + instructions.get(i) + ")";
								index = Integer.MAX_VALUE;
						} else {
								output += instructions.get(i);
						}
						output += ", ";
				}
				System.out.println(output.substring(0, output.length() - 2) + "]");
		}
}
