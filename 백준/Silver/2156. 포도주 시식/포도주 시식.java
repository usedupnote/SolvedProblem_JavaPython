import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000) 
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n];
		int[] compare = new int[n];
		
		num[0] = Integer.parseInt(br.readLine());
		compare[0] = num[0];
		if(n == 1) {
			System.out.println(compare[0]);
			return;
		}
		num[1] = Integer.parseInt(br.readLine());
		compare[1] = num[0] + num[1];
		if(n == 2) {
			System.out.println(compare[1]);
			return;
		}
		num[2] = Integer.parseInt(br.readLine());
		compare[2] = Math.max(Math.max(num[1] + num[2], num[0] + num[2]), compare[1]);
		if(n == 3) {
			System.out.println(compare[2]);
			return;
		}
		
		for (int i = 3; i < n; i++) {
			//둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다.
			//포도주의 양은 1,000 이하의 음이 아닌 정수이다.
			num[i] = Integer.parseInt(br.readLine());
			compare[i] = Math.max(Math.max(compare[i - 3] + num[i - 1] + num[i], compare[i - 2] + num[i]), compare[i-1]);
		}
		
		System.out.println(compare[n-1]);
		br.close();
	}
}