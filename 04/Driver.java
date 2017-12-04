import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<String> passphrases = new ArrayList<>();
        while (in.hasNextLine()) {
            passphrases.add(in.nextLine());
        }
        System.out.println(Passphrase.findNonAnagrams(passphrases));
    }
}
