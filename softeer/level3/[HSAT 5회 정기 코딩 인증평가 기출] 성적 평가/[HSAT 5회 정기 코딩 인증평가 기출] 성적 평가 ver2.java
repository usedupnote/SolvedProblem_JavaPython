import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
            
        int[] finalScoreList = new int[N];
        int[] scoreList, scoreBoard;
        
        for (int k = 0; k < 3; k++) {
        	st = new StringTokenizer(br.readLine());

        	scoreList = new int[N];
            scoreBoard = new int[1002];
            
        	for (int i = 0; i < N; i++) {
        		scoreList[i] = Integer.parseInt(st.nextToken());
        		finalScoreList[i] += scoreList[i];
        		scoreBoard[scoreList[i]]++;
			}
        	
        	for (int i = 999; i >= 0; i--) {
				scoreBoard[i] += scoreBoard[i+1];
			}
        	
        	for (int i = 0; i < N; i++) {
				sb.append(scoreBoard[scoreList[i]+1]+1);
                if (i != N-1) {
        			sb.append(" ");
                }
			}
        	sb.append("\n");
		}
        
        scoreBoard = new int[3002];
        
    	for (int i = 0; i < N; i++) {
    		scoreBoard[finalScoreList[i]]++;
		}
    	
    	for (int i = 2999; i >= 0; i--) {
			scoreBoard[i] += scoreBoard[i+1];
		}
    	
    	for (int i = 0; i < N; i++) {
			sb.append(scoreBoard[finalScoreList[i]+1]+1);
            if (i != N-1) {
    			sb.append(" ");
            }
		}
    	sb.append("\n");

        System.out.print(sb);
    }
}