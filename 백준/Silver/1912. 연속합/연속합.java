import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int max = -1001, num = 0, cur = 0;
        
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			cur += num;
			max = Math.max(max, cur);
			if (cur < 0) cur = 0;
		}
		System.out.println(max);
	}
}