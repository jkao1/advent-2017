public class Checksum {
    public static checksum(ArrayList<int[]> sheet)
    {
        int output = 0;
        for (int[] ary : sheet) {
            int min, max;
            min = max = ary[0];
            for (int n : ary) {
                if (n < min) {
                    min = n;
                }
                if (n > max) {
                    max = n;
                }
            }
            output += max - min;
        }
        return output;
    }
}
