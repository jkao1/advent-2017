import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while (in.hasNextInt()) {
            System.out.println(Spiral.findDistance(in.nextInt()));
        }
    }
}
