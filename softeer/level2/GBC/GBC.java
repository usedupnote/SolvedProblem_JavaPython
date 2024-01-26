import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

		int result = 0;
		
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] checkMap = new int[n+1][2];
		int[][] compareMap = new int[m+1][2];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			checkMap[i] = new int[] {l + checkMap[i-1][0], s};
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			compareMap[i] = new int[] {l + compareMap[i-1][0], s};
		}
		
		int[] count = new int[] {1,1};
		
		while(n+1 != count[0] && m+1 != count[1]) {
			result = Math.max(result, compareMap[count[1]][1] - checkMap[count[0]][1]);
			
			if (checkMap[count[0]][0] < compareMap[count[1]][0]) count[0]++;
			else if (checkMap[count[0]][0] > compareMap[count[1]][0]) count[1]++;
			else {
				count[0]++;
				count[1]++;
			}
		}
		
		System.out.println(result);
    }
}