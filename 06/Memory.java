import java.util.*;

public class Memory {  
  public static int redistribute(ArrayList<Integer> bank) {    
    Hashtable hashtable = new Hashtable();
    int iteration = 0;
    while (!hashtable.containsKey(bank.toString())) {
      hashtable.put(bank.toString(), iteration);
      iteration++;
      
      int maxIndex = getMaxIndex(bank);

      int toRedistribute = bank.get(maxIndex);
      int chunk = toRedistribute / bank.size();
      int leftover = toRedistribute % bank.size();
      int onesToGive = leftover;
      bank.set(maxIndex, 0);
      for (int i = 0; i < bank.size(); i++) {
	if (i > maxIndex && i <= maxIndex + leftover ||
	    maxIndex + leftover > bank.size() - 1 && i <= (maxIndex + leftover) % bank.size()) {
	  if (onesToGive > 0) {
	    bank.set(i, bank.get(i) + 1 + chunk);
	    onesToGive--;
	  } else {
	    bank.set(i, bank.get(i) + leftover + chunk);
	  }
	} else {
	  bank.set(i, bank.get(i) + chunk);
	}
      }
    }
    return iteration - (int) (hashtable.get(bank.toString()));
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
