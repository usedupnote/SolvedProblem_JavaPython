import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] plug = new int[K];
        int[][] order = new int[N+1][2];
        int orderCnt = 0;
        int result = 0;
        
        st = new StringTokenizer(br.readLine());
        if (N < K) {
			for (int i = 0; i < K; i++) {
				plug[i] = Integer.parseInt(st.nextToken());
			}
			
			label : for (int i = 0; i < K; i++) {
				for (int j = 0; j < N; j++) {
					if (order[j][0] == 0) {
						order[j][0] = plug[i];
						order[j][1] = 101;
						for (int k = i+1; k < K; k++) {
							if(plug[i] == plug[k]) {
								order[j][1] = k;
								break;
							}
						}
						continue label;
					}

					if (order[j][0] == plug[i]) {
						order[j][1] = 101;
						for (int k = i+1; k < K; k++) {
							if(plug[i] == plug[k]) {
								order[j][1] = k;
								break;
							}
						}
						continue label;
					}
				}
				result++;
				int max = 0;
				
				for (int j = 0; j < N; j++) {
					if(order[j][1] > max) {
						max = order[j][1];	// 둘 중에 큰거(더 나중에 할 것)
						orderCnt = j;
					}
				}
				order[orderCnt][0] = plug[i];
				order[orderCnt][1] = 101;
				
				for (int j = i+1; j < K; j++) {
					if(plug[i] == plug[j]) {
						order[orderCnt][1] = j;
						break;
					}
				}
			}
		}
        System.out.println(result);
        br.close();
    }
}