import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");

		int compare = Integer.parseInt(st.nextToken());
		int min = compare;
		int max = compare;

		for (int i = 1; i < N; i++) {
			compare = Integer.parseInt(st.nextToken());
			
			if (max < compare) {
				max = compare;
				continue;
			} else if (min > compare) {
				min = compare;
			}
		}
		sb.append(min).append(" ").append(max).toString();
		System.out.println(sb);
		
		br.close();
	}
}