public class Spiral {

    public static int findDistance(int x)
    {
        double sqrt = Math.sqrt(x);
        int level = (int) (Math.floor(sqrt));
        if (level % 2 == 1) {
            level++;
        }
        level /= 2;
        if (Math.floor(sqrt) == Math.ceil(sqrt) && Math.floor(sqrt) % 2 == 1) {
            return (level - 1) * 2;
        }
        int dToLevelOrigin = (int) (x - Math.pow(2 * level - 1, 2)) - 1;
        if ((dToLevelOrigin + 1) % (2 * level) == 0) {
            return level * 2;
        }
        int sideNum = 0;
        int dTracker = dTolevelOrigin;
        while (dTracker > 0) {
            dToLevelOrigin -= n;
            sideNum++;
        }
        System.out.println("" + x + ", " + level + ": " +  dToLevelOrigin);
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            findDistance(i);
        }
    }

}
