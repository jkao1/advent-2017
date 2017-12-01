public class InverseCaptcha {
	public static int inverse(String num)
	{
		int i, sum;
		i = sum = 0;
		while (i < num.length()) {
			if (num.charAt(i) == num.charAt( (i + 1) % num.length() )) {
				sum += num.charAt(i) - '0';
			}
			i++;
		}
		return sum;
	}
	public static int circularInverse(String num)
	{
		int i, sum;
		i = sum = 0;
		while (i < num.length()) {
			if (num.charAt(i) == num.charAt( (i + num.length() / 2) % num.length() )) {
				sum += num.charAt(i) - '0';
			}
			i++;
		}
		return sum;
	}
}
