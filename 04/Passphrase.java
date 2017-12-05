import java.util.*;

public class Passphrase {
  public static int findValidPassphrases(ArrayList<String> passphrases) {
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

  public static int findNonAnagrams(ArrayList<String> passphrases) {
    int numValids = 0;
    for (String passphrase : passphrases) {
      Hashtable table = new Hashtable();
      String[] words = passphrase.split(" ");
      for (String word : words) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortedWord = new String(chars);
        table.put(sortedWord, word);
      }
      if (table.size() == words.length) {
        numValids++;
      }
    }
    return numValids;
  }
}
