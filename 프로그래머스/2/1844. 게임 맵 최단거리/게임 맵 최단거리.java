import java.io.*;
import java.util.*;

class Solution {
    static final int[] dirX = new int[]{0, 0, -1, 1};   //상하좌우
    static final int[] dirY = new int[]{-1, 1, 0, 0};
    static int[] dest;
    static int bfs(int[][] maps, int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        pq.offer(new int[]{1, x, y});
        
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            
            if (poll[1] == dest[0]-1 && poll[2] == dest[1]-1) return poll[0];
            
            for(int d = 0 ; d < 4 ; d++) {
                int dx = poll[1] + dirX[d];
                int dy = poll[2] + dirY[d];
                
                if (0 <= dx && dx<dest[0] && 0<=dy && dy<dest[1] && maps[dx][dy] == 1) {
                    pq.offer(new int[]{poll[0]+1, dx, dy});
                    maps[dx][dy] = poll[0]+1;
                }
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        dest = new int[] {maps.length, maps[0].length};
        int answer = bfs(maps, 0, 0);
        return answer;
    }
}