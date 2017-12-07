import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Circus {
  public final Pattern PROGRAM_NAME_PATTERN;
  private Hashtable<String, Program> programs;

  public Circus(ArrayList<String> singlePrograms, ArrayList<String> linkedPrograms) {
    programs = new Hashtable<>();
    PROGRAM_NAME_PATTERN = Pattern.compile("\\w{3,}");    

    hashSinglePrograms(singlePrograms);
    hashLinkedPrograms(linkedPrograms);
  }
  
  public String findBottomProgram() {
    Program traverser = programs.values().iterator().next();
    System.out.println(programs);
    while (traverser.parent != null) {			  
      traverser = traverser.parent;
    }
    return traverser.name;
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
      Program p = programs.get(name);
      if (p.weight == -1) {
	p.weight = getWeight(program);
      }
      scan.next(); // for "(weight)"
      scan.next(); // for "->"
      while (scan.hasNext()) {
	String cName = scan.next();
	if (cName.contains(",")) {
	  cName = cName.substring(0, cName.length() - 1);
	}
	if (!programs.containsKey(cName)) {
	  Program p = new Program(cName);
	  programs.put(p.name, p);
	}
	Program child = (Program) (programs.get(cName));
	child.parent = p;
      }
    }
  }
}

private class Program {
  public Program parent;
  public String name;
  public int weight;

  public Program(String name) {
    this.name = name;
    weight = -1;
  }

  public Program(String name, int weight) {      
    this.name = name;
    this.weight = weight;
  }

  public String toString() {
    if (parent != null) {
      return name + " (parent: " + parent.name + ")";
    } else {
      return name;
    }
  }
}
}
