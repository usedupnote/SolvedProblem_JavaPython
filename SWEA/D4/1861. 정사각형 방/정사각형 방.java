import java.io.*;
import java.util.*;

public class Solution {
	static final int[] POSX = {-1, 0, 1, 0}; //상 우 하 좌
	static final int[] POSY = {0, 1, 0, -1};
	static int size;
    static int[][] table;
    static int[][] dp;
     
    public static int bfs(int row, int col){
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        else {
            int tempOut = 1;
            int currentValue = table[row][col];
            for (int d = 0; d < 4; d++) {
				int dx = row + POSX[d];
				int dy = col + POSY[d];
				
				if(dx >=0 && dx < size && dy >=0 && dy < size && currentValue+1 == table[dx][dy]){
	                tempOut = Math.max(tempOut, bfs(dx, dy)+1);
	            }
			}
            dp[row][col] = tempOut;
            return dp[row][col];
        }
    }
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int numOfTests = Integer.parseInt(br.readLine());
         
        int testCount = 1;
         
        while(testCount <= numOfTests){
            size = Integer.parseInt(br.readLine());
            table = new int[size][size];
            dp = new int[size][size];
             
            for(int i=0; i<size; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<size; j++){
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int maxValue = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    maxValue = Math.max(maxValue, bfs(i, j));
                }
            }
             
            int out = Integer.MAX_VALUE;
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(dp[i][j] == maxValue){
                        out = Math.min(out, table[i][j]);
                    }
                }
            }
            sb.append("#"+testCount+" "+out+" "+maxValue+"\n");
            testCount++;
        }
        System.out.println(sb);
        br.close();
    }
}