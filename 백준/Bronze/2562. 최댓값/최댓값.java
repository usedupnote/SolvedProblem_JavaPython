import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int compare = Integer.parseInt(st.nextToken());
		int position = 1;
		int max = compare;
		

		for (int i = 2; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			compare = Integer.parseInt(st.nextToken());
			
			if (max < compare) {
				max = compare;
				position = i;
			}
		}
		sb.append(max).append("\n").append(position).toString();
		System.out.println(sb);
		
		br.close();
	}
}