import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int result;
	static char[] DNA;
	static char[] ch = {'A', 'C', 'G', 'T'};
	static int[] chPoint = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		DNA = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
        
		result = 0;
		
		for (int i = 0; i < 4; i++) {
			chPoint[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N; i++) {
			if (i >= M) {
				result++;
				
				for (int j = 0; j < 4; j++) {
					if (chPoint[j] > 0) {
						result--;
						break;
					}
				}
				for (int j = 0; j < 4; j++) {
					if(DNA[i-M] == ch[j]) chPoint[j]++;
				}
			}
			
			if (i == N) break;
			
			for (int j = 0; j < 4; j++) {
				if(DNA[i] == ch[j]) chPoint[j]--;
			}
		}
		System.out.println(result);
        
		br.close();
	}
}