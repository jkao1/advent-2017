import java.util.*;
import java.io.*;

public class InverseCaptcha {
	public static int inverse(String num)
	{
		int i, sum;
		i = sum = 0;
		while (i < num.length()) {
			if (num.charAt(i) == num.charAt( (i + 1) % num.length()) {
				sum += num.charAt(i) - '0';
			}
			i++;
		}
		return sum;
	}

    public static void main(String[] args)
	{
		Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
		long inputNum = in.next();
		System.out.println(inverse(inputNum));
	}
}
