import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<int[]> sheet = new ArrayList<int[]>();
        while (in.hasNextLine()) {
            String[] strArray = in.nextLine().split("\t");
            int[] intArray = new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            sheet.add(intArray);
        }
        System.out.println(Checksum.checksumEvenly(sheet));
    }

    private static String arraysToString(ArrayList<int[]> ary) {
        String output = "[";
        for (int[] a : ary) {
            output += " [";
            for (int n : a) {
                output += n + ", ";
            }
            if (a.length > 0) {
                output = output.substring(0, output.length() - 2);
            }
            output += "],";
        }
        return output.substring(0, output.length() - 1) + "]";
    }
}
