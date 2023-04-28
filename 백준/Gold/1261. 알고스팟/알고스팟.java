import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int x, y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static final int[] dirX = {-1, 1, 0, 0};	//상하좌우
	static final int[] dirY = {0, 0, -1, 1};
	static int N, M;
    static char[][] map;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new char[N][];
        
        for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
        System.out.println(bfs());
        br.close();
    }
	private static int bfs() {
		PriorityQueue<Pos> q = new PriorityQueue<>(new Comparator<Pos>() {

			@Override
			public int compare(Pos o1, Pos o2) {
				return Integer.compare(o1.cnt, o2.cnt);
			}
		});
        
        q.offer(new Pos(0, 0, 0));
        
        map[0][0] = 'x';
        
        int dx, dy;
        
        while (true) {
			Pos poll = q.poll();
			if (poll.x == N-1 && poll.y == M-1) {
				return poll.cnt;
			}
			
			for (int d = 0; d < 4; d++) {
				dx = poll.x + dirX[d];
				dy = poll.y + dirY[d];
				
				if (0<=dx && dx<N && 0<=dy && dy<M && map[dx][dy] != 'x') {
					if (map[dx][dy] == '0') {
						q.offer(new Pos(dx, dy, poll.cnt));
					}
					else {
						q.offer(new Pos(dx, dy, poll.cnt+1));
					}
					map[dx][dy] = 'x';
				}
			}
		}
	}
}