import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[][] medal = new int[N+1][3];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int pos = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 3; j++) {
				medal[pos][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	int result = 1;
    	
    	for (int i = 1; i <= N; i++) {
    		if (medal[i][0] != medal[K][0]) {
				if (medal[i][0] > medal[K][0]) {
					result++;
				}
				continue;
			}
    		if (medal[i][1] != medal[K][1]) {
				if (medal[i][1] > medal[K][1]) {
					result++;
				}
    			continue;
			}
    		if (medal[i][2] != medal[K][2]) {
				if (medal[i][2] > medal[K][2]) {
					result++;
				}
    			continue;
			}
		}
        System.out.println(result);
        br.close();
    }
}