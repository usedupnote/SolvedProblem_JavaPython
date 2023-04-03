import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean result;
	static int[][] location;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

        while (true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// (t ≤ 50)
			int y = Integer.parseInt(st.nextToken());	// (t ≤ 50)
			int z = Integer.parseInt(st.nextToken());	// (t ≤ 50)
			
			if(x==0 && y==z && z==x) break;
			
			if(x==y && y==z)	 						        sb.append("Equilateral");
			else if(Math.max(Math.max(x, y), z) * 2 >= x+y+z)	sb.append("Invalid");
			else if(x==y || y==z || z==x) 				        sb.append("Isosceles");
			else						 				        sb.append("Scalene");
			   
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}