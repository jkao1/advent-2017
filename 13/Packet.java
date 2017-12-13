import java.util.*;

public class Packet {
  public static int findDelay(ArrayList<String> layers, int numLayers) {
    int[] firewall = new int[numLayers + 1];
    for (String layer : layers) {
      firewall[Integer.parseInt(layer.substring(0, layer.indexOf(":")))] =
          Integer.parseInt(layer.substring(layer.indexOf(":") + 2));
    }
    int delay = 0;
    while (true) {
      if (hasCollision(firewall, delay)) {
        delay++;
      } else {
        break;
      }
    }
    return delay;
  }

  private static boolean hasCollision(int[] firewall, int delay) {
    for (int t = delay; t < firewall.length + delay; t++) {
      if (t > 0 && firewall[t - delay] > 0 && t % (firewall[t - delay] * 2 - 2) == 0) {
        return true;
      }
    }
    return false;
  }
}
