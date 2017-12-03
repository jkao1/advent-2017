public class Spiral {
    public static int findDistance(int x)
    {
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

    public static int findFirstGreatest(int x)
    {
        ArrayList<Integer> spiral = new ArrayList<>();
        spira.add(1);
        int i = 0;
        while (spiral.get(i) < x) {
            spiral.add(spiral.get())
        }
    }

    private static int getIndexOr(ArrayList<Integer> ary, int i, int defaultValue) {
        try {
            return ary.get(i);
        } catch (IndexOutOfBoundsException e) {
            return defaultValue;
        }
    }
}
