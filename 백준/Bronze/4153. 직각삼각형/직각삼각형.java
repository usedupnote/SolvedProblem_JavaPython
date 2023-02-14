import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		
		while (x + y + z != 0) {
			if(Math.pow(Math.max(x, Math.max(y, z)), 2) * 2 == Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
		br.close();
	}
}