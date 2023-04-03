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
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());	// (t ≤ 50)

		for (int TC = 1; TC <= t; TC++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	// 편의점의 개수 n (0 ≤ n ≤ 100)
			
			location = new int[n+2][2];
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				//다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다.
				//각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}
			
			v = new boolean[n+2];
			
			//맥주 한 박스에는 맥주가 20개 들어있다.
			//페스티벌에 갈 수 있으면 "happy", 더 이동할 수 없으면 "sad"를 출력한다. 
			sb.append((BFS(0, 20*50)?"happy":"sad") + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static boolean BFS(int current, int beer) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
			
		q.offer(current);
		
		int dist = 0;
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			
			if(poll == n+1) {
				return true;
			}
			// 맨해튼 거리
			for (int i = 1; i < n + 2; i++) {
				if (v[i] || i == poll) continue;
				dist = Math.abs(location[poll][0] - location[i][0]) + Math.abs(location[poll][1] - location[i][1]);
				if(beer < dist) continue;
				v[i] = true;
				q.offer(i);
			}
		}
		
		return result;
	}
}