import java.util.*;

public class Passphrase {
    public static int findValidPassphrases(ArrayList<String> passphrases)
    {
        int numValids = 0;
        for (String passphrase : passphrases) {
            List<String> words = new ArrayList<>(Arrays.asList(passphrase.split(" ")));
            Set<String> set = new HashSet<String>(words);
            if (set.size() == words.size()) {
                numValids++;
            }
        }
        return numValids;
    }
}
