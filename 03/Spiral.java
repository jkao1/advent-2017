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
        Node head = new Node(1);
        Node second = new Node(1);
        head.right = second;
        second.left = head;
        tail = second;
        int direction = 0;
        int i = 0;
        while (tail.value < x) {
            Node next = new Node();
            if (direction == 0) {
                next.down = tail;
                tail.up = next;
                next.downLeft = tail.left;
                tail.left.upRight = next;
            }
            i++;
            tail = next;
            next.computeValue();
        }
    }

    private class Node {
        public Node right, upRight, up, upLeft, left, downLeft, down, downRight;
        public int value;
        public Node() {}
        public Node(int value) {
            this.value = value;
        }
        public void computeValue() {
            int tempVal = 0;
            for (Node n : new Node[]{right, upRight, up, upLeft, left, downLeft, down, downRight}) {
                tempVal = n == null ? 0 : n.value;
            }
            value = tempVal;
        }
    }
}
