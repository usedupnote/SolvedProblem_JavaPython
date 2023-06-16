import java.io.*;
import java.util.*;

public class Main {
	static int[] coin = {500,100,50,10,5,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;			
		int[] num = new int[3];
		st = new StringTokenizer(br.readLine());
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		num[2] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		char[] ch = br.readLine().toCharArray();
		for (char p : ch) {
			if (p == 'A') sb.append(num[0]).append(" ");
			if (p == 'B') sb.append(num[1]).append(" ");
			if (p == 'C') sb.append(num[2]).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}