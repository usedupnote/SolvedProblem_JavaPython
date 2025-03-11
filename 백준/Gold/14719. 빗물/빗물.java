import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		long height;
		int position;
		
		public Point(long height, int position) {
			this.height = height;
			this.position = position;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		long H = Long.parseLong(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		long[] M = new long[W];
		long[] V = new long[W];
		
		st = new StringTokenizer(br.readLine());
		
		int maxPos = 0;
		
		for (int i = 0; i < W; i++) {
			M[i] = Long.parseLong(st.nextToken());
			if (M[i] > M[maxPos]) {
				maxPos = i;				
			}
		}

		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return Long.compare(o1.height, o2.height);
			}
		});
		
		for (int i = maxPos; i < W; i++) {
			if (M[i] != 0) {
				q.offer(new Point(M[i], i));
			}
		}
		
		while(!q.isEmpty()) {
			Point poll = q.poll();
			
			for (int i = poll.position; i >= maxPos; i--) {
				if(V[i] > poll.height) break;
				V[i] = poll.height;
			}
		}

		for (int i = maxPos; i >= 0; i--) {
			if (M[i] != 0) {
				q.offer(new Point(M[i], i));
			}
		}
		
		while(!q.isEmpty()) {
			Point poll = q.poll();

			for (int i = poll.position; i <= maxPos; i++) {
				if(V[i] > poll.height) break;
				V[i] = poll.height;
			}
		}
		System.out.println(Arrays.stream(V).sum() - Arrays.stream(M).sum());
		br.close();
	}
}
