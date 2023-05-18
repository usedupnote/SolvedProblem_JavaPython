import java.io.*;
import java.util.*;

public class Solution {	
	static int N,M,K,A,B;
	static int[] timeA, timeB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken())-1;
			B = Integer.parseInt(st.nextToken())-1;
			
			
			st = new StringTokenizer(br.readLine());
			timeA = new int[N];
			timeB = new int[M];
			for (int i = 0; i < N; i++) {
				timeA[i] = Integer.parseInt(st.nextToken());				
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				timeB[i] = Integer.parseInt(st.nextToken());				
			}

			//고객 k의 도착 시간 저장
			ArrayDeque<int[]> tk = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				tk.addLast(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			int result = 0;
			int time = 0;
			int[] receptionDest = new int[N];
			int[] repareDest = new int[N];

			PriorityQueue<int[]> rtk = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return Integer.compare(o1[2], o2[2]);
					}
					return Integer.compare(o1[1], o2[1]);
				}
			});		//Repare Tesk
			
			while (true) {
				// 가장 빠른 번호의 사람이 현재 시간보다 같거나 빨리 왔다면 대기하는 중인 손님
				start: while (!tk.isEmpty() && time >= tk.peekFirst()[1]) {
					//모든 접수창구를 돌면서 현재 시간보다 빠른 접수창구 찾아서 거기로 배정
					for (int i = 0; i < N; i++) {
						if (time>=receptionDest[i]) {
							receptionDest[i] = time + timeA[i];
							// [고객번호, 작업 종료시간, 나온 접수 창구 위치]
							rtk.offer(new int[] {tk.pollFirst()[0], receptionDest[i]-1, i});	
							continue start;
						}
					}
					break;
				}
			
				start: while (!rtk.isEmpty() && time >= rtk.peek()[1]) {
					//모든 접수창구를 돌면서 현재 시간보다 빠른 접수창구 찾아서 거기로 배정
					for (int i = 0; i < M; i++) {
						if (time>=repareDest[i]) {
							repareDest[i] = time + timeB[i];
							int[] cust = rtk.poll();
							if (cust[2] == A && i == B) {
								result+= cust[0];
							}
							continue start;
						}
					}
					break;
				}

				if (tk.isEmpty() && rtk.isEmpty()) {
					break;
				}
				time++;
			}
			sb.append("#").append(TC).append(" ").append(result==0?-1:result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}