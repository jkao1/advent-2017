import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Circus {
  public final Pattern PROGRAM_NAME_PATTERN, PROGRAM_WEIGHT_PATTERN;
  private Hashtable programs;

  public Circus(ArrayList<String> singlePrograms, ArrayList<String> linkedPrograms) {
    programs = new Hashtable();
    PROGRAM_NAME_PATTERN = Pattern.compile("\\w{3,}");
    PROGRAM_WEIGHT_PATTERN = Pattern.compile("\\d{1,}");
    
    hashSinglePrograms(singlePrograms);
    hashLinkedPrograms(linkedPrograms);
  }
  
  public String findBottomProgram() {
    for (Object program : programs.values()) {
      Program p = (Program) program;
      if (p.children.size() == 0) {
	return p.name;
      }
    }
    return "";
  }

  private void hashSinglePrograms(ArrayList<String> singlePrograms) {    
    // format of program string: yvpwz (50)
    for (String program : singlePrograms) {
      Scanner scan = new Scanner(program);
      String name = scan.next();
      int weight = getWeight(program);
      programs.put(name, new Program(name, weight));
    }
  }

  private int getWeight(String program) {
    String weight = "";
    boolean scanningInt = false;
    for (int i = 0; i < program.length(); i++) {
      if (scanningInt) {
	if (program.charAt(i) == ')') {
	  break;
	}
	weight += program.charAt(i);
      } else {
	if (program.charAt(i) == '(') {
	  scanningInt = true;
	}
      }
    }
    return Integer.parseInt(weight);
  }
	
  private void hashLinkedPrograms(ArrayList<String> linkedPrograms) {
    // format of program string: ozfsktz (56) -> xzwjii, uhxjy
    for (String program : linkedPrograms) {
      Scanner scan = new Scanner(program);
      String name = scan.next();
      int weight = Integer.parseInt(scan.findInLine(PROGRAM_WEIGHT_PATTERN));
      Program p = new Program(name, weight);
      while (scan.hasNext(PROGRAM_NAME_PATTERN)) {
	Program child = (Program) (programs.get(scan.next(PROGRAM_NAME_PATTERN)));
	p.children.add(child);
      }
      programs.put(name, p);
    }
  }

  private class Program {
    public ArrayList<Program> children;
    public String name;
    public int weight;

    public Program(String name, int weight) {
      children = new ArrayList<>();
      this.name = name;
      this.weight = weight;
    }
  }
}
