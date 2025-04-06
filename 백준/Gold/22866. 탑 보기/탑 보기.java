import java.io.*;
import java.util.*;

public class Main {
	static class Building {
		int height, position;

		public Building(int height, int position) {
			this.height = height;
			this.position = position;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] city = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] result = new int[N][2];
		
		PriorityQueue<Building> q = new PriorityQueue<>(new Comparator<Building>() {

			@Override
			public int compare(Building o1, Building o2) {
				return Integer.compare(o1.height, o2.height);
			}
		});
		
		for (int i = 0; i < N; i++) {
			while (!q.isEmpty()) {
				if (q.peek().height > city[i]) break;
				q.poll();
			}
			if (!q.isEmpty()) {
				result[i][0] = q.size();
				result[i][1] = q.peek().position;
			}
			q.offer(new Building(city[i], i));
		}
		
		q.clear();
		
		for (int i = N-1; i >= 0; i--) {
			while (!q.isEmpty()) {
				if (q.peek().height > city[i]) break;
				q.poll();
			}
			if (!q.isEmpty()) {
				if (result[i][0] == 0) {
					result[i][0] += q.size();
					result[i][1] = q.peek().position;
				} else {
					result[i][0] += q.size();
					if(Math.abs(i - result[i][1]) > Math.abs(i - q.peek().position)) {
						result[i][1] = q.peek().position;
					}
				}
			}
			q.offer(new Building(city[i], i));
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(result[i][0]);
			
			if (result[i][0] != 0) {
				sb.append(" ").append(result[i][1]+1);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
        br.close();
    }
}