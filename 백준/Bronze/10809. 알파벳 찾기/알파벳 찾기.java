import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine();
		
		char[] ch = st.toCharArray();
		int[] count = new int[26];
		
		for (int i = 0; i < 26; i++) {
			count[i] = -1;
		}
		
		for (int i = 0; i < ch.length; i++) {
			if (count[(int)ch[i] - 97] == -1) {
				count[(int)ch[i] - 97] = i;
			}
		}
		System.out.println(Arrays.toString(count).replace("[", "").replace("]", "").replace(",", ""));
	}
}