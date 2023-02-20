import java.io.*;
import java.util.*;

public class Main {
	static final int[] dirX = {0, 0, 1, 1}; // 좌상 우상 좌하 우하
	static final int[] dirY = {0, 1, 0, 1};
	static int N, r, c, count, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		questZ(Math.pow(2, N), 0, 0);
		
		System.out.println(result);
	}

	static void questZ(double d, double x, double y) {
		if (d==0) return;
		if (r < x + d/2 && c < y + d/2) {
			result += 0;
			questZ(d/2, x, y);
		} else if(r < x + d/2 && c < y + d) {
			result += (d/2) * (d/2);
			questZ(d/2, x, y + d/2);
		} else if(r < x + d && c < y + d/2) {
			result += (d/2) * (d/2) * 2;
			questZ(d/2, x + d/2, y);
		} else {
			result += (d/2) * (d/2) * 3;
			questZ(d/2, x + d/2, y + d/2);
		}
	}
}