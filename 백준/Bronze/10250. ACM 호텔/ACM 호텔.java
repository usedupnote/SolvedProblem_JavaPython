import java.io.*;
import java.util.*;

public class Main {		
	static int T;
	static int floor;
	static int roomNum;
	
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			floor = (N % H) == 0 ? H : N % H;

			sb.append(floor);
			
			roomNum = (N % H) == 0 ? (N / H) : (N / H) + 1;
			if (roomNum < 10) {
				sb.append(0);
			}
			sb.append(roomNum).append("\n");
		}
		System.out.println(sb.toString());
	}
}