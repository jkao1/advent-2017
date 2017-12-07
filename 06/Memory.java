import java.util.*;

public class Memory {
  public static int redistribute(ArrayList<Integer> bank) {
    Hashtable hashtable = new Hashtable();
    while (!hashtable.containsKey(bank.toString())) {
      System.out.println(bank);
      hashtable.put(bank.toString(), "placeholder");
      int maxIndex = getMaxIndex(bank);

      int toRedistribute = bank.get(maxIndex);
      int chunk = toRedistribute / (bank.size() - 1);
      int leftover = toRedistribute % (bank.size() - 1);
      System.out.println("redistributing max of " + bank.get(maxIndex) + " to chunks of " + chunk + " and leftover of " + leftover);
	
      for (int i = 0; i < bank.size(); i++) {
	if (chunk == 0) {
	  if (i == maxIndex) {
	    bank.set(i, 0);
	  } else if (i > maxIndex && i <= maxIndex + leftover|| i < maxIndex && maxIndex + leftover > bank.size() && i <= (maxIndex + leftover) % bank.size()) {
	    bank.set(i, bank.get(i) + 1);
	  }
	} else {
	  if (i == maxIndex) {
	    bank.set(i, leftover);
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
