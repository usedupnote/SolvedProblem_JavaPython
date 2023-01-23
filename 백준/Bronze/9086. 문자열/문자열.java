import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		sc.nextLine();
		
		for (int i = 0; i < test_case; i++) {
			String st = sc.nextLine();
			char[] ch = st.toCharArray();
			
			System.out.println(ch[0] + "" + ch[ch.length - 1]);
		}
	}
}