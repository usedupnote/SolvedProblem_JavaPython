import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] num = new int[10];
		
		for (int TC = 0; TC< T; TC++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
			sb.append(num[7]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}