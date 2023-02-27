import java.io.*;
import java.util.*;

public class Main {
	static class area implements Comparable<area>{
		int start;	// 봉우리의 시작점
		int end;	// 봉우리의 종료점

		// 시작점, 종료점 위치를 받아와서 저장
		public area(int start, int end) {
			this.start = start;
			this.end = end;
		}

		// start를 기준으로 정렬 (오름차순)
		@Override
		public int compareTo(area o) {
			return this.start - o.start;
		}

		// to string을 통해 출력 확인
		@Override
		public String toString() {
			return "points [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	static int N;			
	static int[][] point;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		PriorityQueue<area> p = new PriorityQueue<>();
		
		// 곡선을 표현하는 직교다각형의 꼭짓점의 개수 N (4 ≤ N ≤ 10^6)
		N = Integer.parseInt(st.nextToken());
		
		// N개의 각 줄에는 직교다각형의 경계선을 따라갈 때 만나는 꼭짓점 순서대로 각 꼭짓점의 좌표
		point = new int[N][2];

		// (이해가...?) 이순서의 방향은 가장 왼쪽에 있는 수직선분인 변을 볼 때 아래에서 위로 올라가는 방향이다.
		// 또한 y좌표가 0인 경우는 없으며, x축과 교차하는 변이 반드시 하나 이상 존재한다.
		st = new StringTokenizer(br.readLine());
		point[0][0] = Integer.parseInt(st.nextToken());
		point[0][1] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// −10^9 <= x, y <= 10^9 (x 와 y모두 int 범위 내 존재)
			point[i][0] = Integer.parseInt(st.nextToken());	// x
			point[i][1] = Integer.parseInt(st.nextToken());	// y
			
			// x축을 지날 때 (두 y좌표 값의 곱이 음수일 때) q에 넣기
			//if((point[i][1]) * (point[i-1][1]) < 0) stack.add(point[i][0]);
			if((point[i][1]) > 0 && (point[i-1][1]) < 0) stack.add(point[i][0]);	// 양수에서 음수로
			if((point[i][1]) < 0 && (point[i-1][1]) > 0) stack.add(point[i][0]);	// 음수에서 양수로
		}
		
		if((point[0][1]) > 0 && (point[N-1][1]) < 0) stack.add(point[0][0]);	// 양수에서 음수로
		if((point[0][1]) < 0 && (point[N-1][1]) > 0) stack.add(point[0][0]);	// 음수에서 양수로

		// 가장 처음이 양수에서 시작했다면 가장 뒤로 넣어서 페어가 맞도록 조절
		if(point[0][1] > 0) stack.offer(stack.poll());
		
		// p에 각 area 넣어주기
		while (!stack.isEmpty()) {
			int start = stack.poll();
			int end = stack.poll();
			if(start < end) p.offer(new area(start, end));
			else			p.offer(new area(end, start));
		}
				
		// x축의 위쪽 영역에 나타나는 봉우리들 중
		int resultA = 0;
		int resultB = 1;
		int checkA = -999999999;
		int checkB = 999999999;
		while (!p.isEmpty()) {
			area current = p.poll();
			// 1. 다른 봉우리에 의해 포함되지 않는 봉우리 개수
			// check가
			if(checkA < current.start) {
				resultA++;
				checkA = current.end;
			}

			// 2. 다른 봉우리를 포함하지 않는 봉우리 개수
			if(current.start > checkB) resultB++;
			checkB = current.end;
		}
		System.out.println(resultA + " " + resultB);
	}
}