import java.util.*;

class Solution {
    static final int[] dirX = new int[] {0, -1, 0, 1};
    static final int[] dirY = new int[] {-1, 0, 1, 0};

    static int[] BFS(int x, int y, int cnt, int[][] land, int Col, int Row) {
        int cntBFS = 0;
        int maxY = y;
        int minY = y;
        
        ArrayDeque<int[]> ad = new ArrayDeque<>();
        
        cntBFS++;
        ad.offer(new int[] {x, y});
        land[x][y] += cnt;
        
        while(!ad.isEmpty()) {
            int[] poll = ad.poll();
            
            for(int d = 0 ; d < 4 ; d++) {
                int dx = poll[0] + dirX[d];
                int dy = poll[1] + dirY[d];
                
                if(0<=dx && dx<Col && 0<=dy && dy<Row && land[dx][dy] == 1){
                    land[dx][dy] += cnt;
                    ad.offer(new int[] {dx, dy});
                    cntBFS++;
                    if (dy > maxY) {
                        maxY = dy;
                    } else if (dy < minY){
                        minY = dy;
                    }
                }
            }
        }
        return new int[] {minY, maxY, cntBFS};
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int landCol = land.length;
        int landRow = land[0].length;
        int[] landRowCnt = new int[land[0].length + 1];
        int cnt = 1;
        
        for(int i = 0 ; i < landCol ; i++) {
            for(int j = 0 ; j < landRow ; j++) {
                if(land[i][j] == 1) {
                    int[] resultBFS = BFS(i, j, cnt++, land, landCol, landRow);
                    for (int k = resultBFS[0] ; k <= resultBFS[1] ; k++) {
                        landRowCnt[k] += resultBFS[2];
                    }
                }
            }
        }
        
        for(int i = 0 ; i < landRow ; i++) {
            if (answer < landRowCnt[i]) answer = landRowCnt[i];
        }
        
        return answer;
    }
}