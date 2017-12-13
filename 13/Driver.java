import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    ArrayList<String> layers = new ArrayList<>();
    while (in.hasNextLine()) {
      layers.add(in.nextLine());
    }
    String layer = layers.get(layers.size() - 1);
    System.out.println(Packet.findDelay(layers, Integer.parseInt(layer.substring(0, layer.indexOf(":")))));
  }
}
