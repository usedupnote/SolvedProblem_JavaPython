import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[3], o2[3]);
			}
		});
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		q.offer(new int[] {x, y, 0, 0});	// 벽장1 위치, 벽장2 위치, 현재 벽장 문 사용 순서, 이동횟수
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		int[] score = new int[N];
		int[] used = new int[num];
		
		Arrays.fill(score, 999_999_999);
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			used[i] = Integer.parseInt(st.nextToken())-1;
		}

		while (!q.isEmpty()){
			int[] poll = q.poll();
			
			// 현재 사용할 벽장의 크기를 넘어섰다면 out
			if(poll[2] == num) {
				System.out.println(poll[3]);
				break;
			}
			int distX = Math.abs(used[poll[2]] - poll[0]);
			int distY = Math.abs(used[poll[2]] - poll[1]);
			
			q.offer(new int[] {used[poll[2]], poll[1], poll[2]+1, poll[3] + distX});
			q.offer(new int[] {poll[0], used[poll[2]], poll[2]+1, poll[3] + distY});
		}
	}
}