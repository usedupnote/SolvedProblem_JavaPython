import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] diri = {-1, 0, 1, 0}; //상 우 하 좌
		int[] dirj = {0, 1, 0, -1};
		int[][] maze = new int[N][M];
		ArrayDeque<int[]> mazeSearch = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = Character.valueOf(ch[j]) - '0';
			}
		}
		
		mazeSearch.offer(new int[] {0, 0});
		
		while (mazeSearch.size() != 0) {
			int[] search = mazeSearch.poll();
			
			if (search[0] == N-1 && search[1] == M-1) break;
			
			for (int i = 0; i < 4; i++) {
				int di = search[0] + diri[i];
				int dj = search[1] + dirj[i];
				
				if (di >=0 && di < N && dj >= 0 && dj < M && maze[di][dj] == 1) {
					maze[di][dj] = maze[search[0]][search[1]] + 1;
					mazeSearch.offer(new int[] {di, dj});
				}
			}
		}
		System.out.println(maze[N-1][M-1]);
	}
}