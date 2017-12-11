public class Hex {
  public static int findFewestSteps(String[] directions) {
    int hexesUp, hexesRight;
    hexesUp = hexesRight = 0;
    for (String s : directions) {
      if (s.length() == 2) {
        hexesUp += directionToValue(s.charAt(0));
        hexesRight += directionToValue(s.charAt(1));
      } else if (s.length() == 1) { // n or s
        hexesUp += directionToValue(s.charAt(0)) * 2;
      }
    }
    int ans;
    if (hexesUp == hexesRight) {
      ans = hexesUp;
    } else if (hexesUp > hexesRight) {
      ans = hexesRight + (hexesUp - hexesRight) / 2;
    } else {
      ans = hexesUp + (hexesRight - hexesUp) / 2;
    }
    return Math.abs(ans);
  }

  private static int directionToValue(char s) {
    switch (s) {
      case 'n': return 1;
      case 'e': return 1;
      case 'w': return -1;
      case 's': return -1;
    }
    return 0;
  }
}
