import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, Integer> home;
	
	static class Road {
		int homeA, homeB;
		int price;
		public Road(int homeA, int homeB, int price) {
			this.homeA = homeA;
			this.homeB = homeB;
			this.price = price;
		}
	}
	
	static boolean union(int homeA, int homeB) {
		if (unionFind(homeA) == unionFind(homeB)) {
			return false;
		}
		
		home.put(home.get(homeB), home.get(homeA));
		return true;
	}
	
	static int unionFind(int homeNum) {
		if (homeNum == home.get(homeNum)) {
			return homeNum;
		}
		home.put(homeNum, unionFind(home.get(homeNum)));
		return home.get(homeNum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		int maxValue = 0;

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 간선 정렬을 위해 priorityQueue를 사용
		PriorityQueue<Road> roads = new PriorityQueue<>(new Comparator<Road>() {

			@Override
			public int compare(Road o1, Road o2) {
				return Integer.compare(o1.price, o2.price);
			}
		});
		
		// 간선 입력 및 정렬
		home = new HashMap<>();
		for (int d = 0; d < M; d++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			home.put(A, A);
			home.put(B, B);
			
			roads.offer(new Road(A, B, C));
		}
		
		while (!roads.isEmpty()) {
			Road poll = roads.poll();
			
			if(union(poll.homeA, poll.homeB)) {
				result += maxValue;
				maxValue = poll.price; 
			}
		}
		
		System.out.println(result);
        br.close();
    }
}