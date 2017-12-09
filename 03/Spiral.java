public class Spiral {
  public static int findDistance(int x) {
    double sqrt = Math.sqrt(x);
    int level = (int) (Math.floor(sqrt));
    if (level % 2 == 1) {
      level++;
    }
    level /= 2;
    if (level < 2) {
      return level;
    }
    if (Math.floor(sqrt) == Math.ceil(sqrt) && Math.floor(sqrt) % 2 == 1) {
      return (level - 1) * 2;
    }
    int dToLevelOrigin = (int) (x - Math.pow(2 * level - 1, 2)) - 1;
    if ((dToLevelOrigin + 1) % (2 * level) == 0) {
      return level * 2;
    }
    int sideNum = 0;
    int dTracker = dToLevelOrigin;
    while (dTracker - 2 * level >= 0) {
      dTracker -= 2 * level;
      sideNum++;
    }
    int sideMid = (int) (Math.pow(2 * level - 1, 2)) + level + 2 * level * sideNum;
    return level + Math.abs(sideMid - x);
  }

  public static boolean isSpiralCorner(int x) {
    double sqrt = Math.sqrt(x);
    int level = (int) (Math.floor(sqrt));
    if (level % 2 == 1) {
      level++;
    }
    level /= 2;
    int dToLevelOrigin = (int) (x - Math.pow(2 * level - 1, 2)) - 1;
    if ((dToLevelOrigin + 1) % (2 * level) == 0) {
      return true;
    }
    return false;
  }

  public static void printlnSpiral(int[][] spiral) {
    String output = "";
    for (int[] ary : spiral) {
      for (int i : ary) {
        output += i + "    ";
      }
      output += "\n";
    }
    System.out.println(output);
  }

  public static int findLeastAfter(int limit, int size) {
    int[][] spiral = new int[size][size];
    int x, y, i, d;
    x = y = spiral.length / 2;
    i = 2;
    d = 1; // right=0, up=1, left=2, down=3

    int[][] movements = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    spiral[y][x] = 1;
    x++;
    spiral[y][x] = 1;

    while (spiral[y][x] < limit) {
      if (i % 2 == 1 && isPerfectSquare(i)) {
      } else if (i > 2 && (i - 1) % 2 == 1 && isPerfectSquare(i - 1)) {
        d++;
      } else if (isSpiralCorner(i)) {
        d++;
      }
      x += movements[d % 4][0];
      y += movements[d % 4][1];
      spiral[y][x] = calculateFriends(spiral, x, y);
      i++;
    }
    return spiral[y][x];
  }

  private static boolean isPerfectSquare(int n) {
    double sqrt = Math.sqrt(n);
    return Math.floor(sqrt) == Math.ceil(sqrt);
  }

  public static int calculateFriends(int[][] spiral, int x, int y) {
    return spiral[y][x + 1]
        + spiral[y][x - 1]
        + spiral[y + 1][x + 1]
        + spiral[y + 1][x - 1]
        + spiral[y + 1][x]
        + spiral[y - 1][x + 1]
        + spiral[y - 1][x - 1]
        + spiral[y - 1][x];
  }
}
