import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][2];
		
		for (int T = 0; T < 3; T++) {
			int[][] current = new int[N][2];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				map[i][0] += current[i][0] += Integer.parseInt(st.nextToken());
				map[i][1] = i;
				current[i][1] = i;
			}
			sorting(current);
		}
		sorting(map);
		System.out.println(sb);
	}
	private static void sorting(int[][] current) throws IOException {

		Arrays.sort(current, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		int[] result = new int[N];
		result[current[0][1]] = 1;
		for (int i = 1; i < N; i++) {
			if (current[i][0] == current[i-1][0]) {
				result[current[i][1]] = result[current[i-1][1]];
			} else {
				result[current[i][1]] = i+1;
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		sb.append("\n");
	}
}