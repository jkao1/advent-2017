import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<int[]> sheet = new ArrayList();
        while (in.hasNextLine()) {
            sheet.add(in.nextLine().split('\t'));
        }
        System.out.println(sheet);
        System.out.println(Checksum.checksum(sheet));
    }
}
