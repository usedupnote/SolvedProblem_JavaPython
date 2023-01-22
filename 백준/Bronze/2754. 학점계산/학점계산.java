import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		
		Map<String, Double> mp = new HashMap<String, Double>();

		mp.put("A+", 4.3);
		mp.put("A0", 4.0);
		mp.put("A-", 3.7);
		mp.put("B+", 3.3);
		mp.put("B0", 3.0);
		mp.put("B-", 2.7);
		mp.put("C+", 2.3);
		mp.put("C0", 2.0);
		mp.put("C-", 1.7);
		mp.put("D+", 1.3);
		mp.put("D0", 1.0);
		mp.put("D-", 0.7);
		mp.put("F", 0.0);
		
		System.out.println(mp.get(st));
		sc.close();
	}
}