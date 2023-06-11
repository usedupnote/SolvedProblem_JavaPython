import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
        
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int result = 1;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (num[i] == num[i-1]) {
				cnt++;
			} else {
				result = Math.max(result, cnt);
				cnt = 1;
			}
		}
		result = Math.max(result, cnt);
		
		System.out.println(result);
		br.close();
	}
}