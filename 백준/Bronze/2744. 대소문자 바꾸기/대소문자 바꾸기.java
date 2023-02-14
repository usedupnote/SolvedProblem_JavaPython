import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		
		char[] ch = st.toCharArray();
		
		for (char i : ch) {
			if ((int)i <= 90) {
				System.out.print((char)((int)i + 32));
			} else {
				System.out.print((char)((int)i - 32));
			}
		}
		sc.close();
	}
}