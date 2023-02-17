import java.io.*;
import java.util.*;

public class Main {
	static int[] rotX = {1, 0, -1, 0}; // 하 우 상 좌
	static int[] rotY = {0, 1, 0, -1};
    static int N, M, K;
    static int[][] cycle;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[K][3];

        for(int k = 0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            cycle[k][0] = Integer.parseInt(st.nextToken()) - 1;
            cycle[k][1] = Integer.parseInt(st.nextToken()) - 1;
            cycle[k][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0, new int[K], new boolean[K]);

        System.out.printf("%d", min);
    }

    public static void permutation(int cnt, int[] arr, boolean[] visited) {
        if(cnt == K) {
            doCycle(arr);
            return;
        }
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt+1, arr, visited);
            visited[i] = false;
        }
    }

    public static void doCycle(int[] arr) {
        int[][] tmp = copyMap();

        for(int k=0; k<K; k++) {
            int r = cycle[arr[k]][0];
            int c = cycle[arr[k]][1];
            int S = cycle[arr[k]][2];
    		
    		for (int s = 1; s <= S; s++) {
    			int save = tmp[r-s][c-s];

        		int dx = r-s;
        		int dy = c-s;
        		
        		for (int d = 0; d < 4; d++) {

        			while (true) {
        				dx += rotX[d];
        				dy += rotY[d];
        				if(dx >= r-s && dx <= r+s && dy >= c-s && dy <= c+s) {
        					tmp[dx - rotX[d]][dy - rotY[d]] = tmp[dx][dy];
        				}else {
        					break;
        				}
        			}
        			dx -= rotX[d];
        			dy -= rotY[d];
        		}
        		tmp[r-s][c-s + 1] = save;
			}
        }
        getAnswer(tmp);
    }

    public static int[][] copyMap() {
        int[][] tmp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        return tmp;
    }

    public static void getAnswer(int[][] tmp) {
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += tmp[i][j];
            }
            if(min > sum) min = sum;
        }
    }
}