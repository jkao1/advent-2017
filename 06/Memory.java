import java.util.*;

public class Memory {
  public static int redistribute(ArrayList<Integer> bank) {
    Hashtable hashtable = new Hashtable();
    while (!hashtable.containsKey(bank.toString())) {
      System.out.println(bank);
      hashtable.put(bank.toString(), "placeholder");
      int maxIndex = getMaxIndex(bank);

      int toRedistribute = bank.get(maxIndex) % (bank.size() - 1);
      int chunk = toRedistribute / (bank.size() - 1);
      for (int i = 0; i < bank.size(); i++) {
	if (toRedistribute == 0 && chunk == 0) {
	  break;
	}
	if (i == maxIndex) {
	  bank.set(i, bank.get(i) - toRedistribute);
	} else {
	  if (toRedistribute > 0) {
	    bank.set(i, bank.get(i) + chunk + 1);
	    toRedistribute--;
	  } else {
	    bank.set(i, bank.get(i) + chunk);
	  }
	}
      }
    }
    return hashtable.size();
  }

  private static int getMaxIndex(ArrayList<Integer> array) {
    int max, maxIndex;
    max = maxIndex = 0;
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) > max) {
	max = array.get(i);
	maxIndex = i;
      }
    }
    return maxIndex;
  }
}
