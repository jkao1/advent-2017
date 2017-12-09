import java.util.*;

public class Register {
  public static int findLargestRegister(ArrayList<String> instructions) {
    Map<String, Integer> map = new HashMap<>();
    int maxValue = Integer.MIN_VALUE;

    for (String instruction : instructions) {
      // instruction format: b inc 5 if a > 1
      Scanner scan = new Scanner(instruction);
      String rName = scan.next();
      String direction = scan.next();
      int magnitude = scan.nextInt();
      scan.next(); // "if"
      String condRName = scan.next();
      String operator = scan.next();
      int condValue = scan.nextInt();

      if (!map.containsKey(rName)) {
        map.put(rName, 0);
      }
      if (!map.containsKey(condRName)) {
        map.put(condRName, 0);
      }
      if (evalCond(operator, condRName, condValue, map)) {
        int vector = magnitude * (direction.equals("inc") ? 1 : -1);
        int newValue = map.get(rName) + vector;
        if (newValue > maxValue) {
          maxValue = newValue;
        }
        map.put(rName, newValue);
      }
    }

    return maxValue;
  }

  private static boolean evalCond(String operator, String condRName, int condValue, Map map) {
    int rValue = (int) map.get(condRName);
    switch (operator) {
      case "<":
        return rValue < condValue;
      case ">":
        return rValue > condValue;
      case ">=":
        return rValue >= condValue;
      case "<=":
        return rValue <= condValue;
      case "==":
        return rValue == condValue;
      case "!=":
        return rValue != condValue;
    }
    throw new IllegalArgumentException(operator + " is not a valid operator.");
  }

  private static int findLargestValue(Map<String, Integer> map) {
    int max = Integer.MIN_VALUE;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
      }
    }
    return max;
  }
}
