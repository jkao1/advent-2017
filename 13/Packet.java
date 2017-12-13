import java.util.*;

public class Packet {
  public static int findSeverity(ArrayList<String> layers, int numLayers) {
    int[] firewall = new int[numLayers + 1];
    for (String layer : layers) {
      firewall[Integer.parseInt(layer.substring(0, layer.indexOf(":")))] = Integer.parseInt(layer.substring(layer.indexOf(":") + 2));
    }
    int severity = 0;
    if (firewall[1] == 1) {
      severity += firewall[1];
    }
    for (int t = 2; t < firewall.length; t++) {
      if (firewall[t] > 0 && t % (firewall[t] * 2 - 2) == 0) {
        severity += t * firewall[t];
      }
    }
    return severity;
  }
}
