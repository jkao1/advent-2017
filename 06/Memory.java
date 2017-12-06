import java.util.*;

public class Memory {
  public static int redistribute(ArrayList<Integer> bank) {
    Hashtable hashtable = new Hashtable();
    while (!hashtable.containsKey(bank.toString())) {
      int maxIndex = getMaxIndex(bank);
    }
  }

  private static int getMatIndex(ArrayList<Integer> array) {
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
