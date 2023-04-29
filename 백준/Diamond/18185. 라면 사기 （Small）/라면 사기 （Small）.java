import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] map = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	map[i] = Integer.parseInt(st.nextToken());
		}
        
        int result = 0;
        int checkMin = 0;
        for (int i = 0; i < N; i++) {
			if (map[i] == 0) continue;
			
			if (i+1 < N && map[i]>0 && map[i+1]>0) {
				if (i+2 < N && map[i+1] > map[i+2]) {
					checkMin = Math.min(map[i], map[i+1] - map[i+2]);
					
					map[i] -= checkMin;
					map[i+1] -= checkMin;
					
					result += checkMin * 5;
				}

				if (i+2 < N && map[i]>0 && map[i+1]>0  && map[i+2]>0) {
					checkMin = Math.min(map[i], Math.min(map[i+1], map[i+2]));
					
					map[i] -= checkMin;
					map[i+1] -= checkMin;
					map[i+2] -= checkMin;
					
					result += checkMin * 7;
				}
				
				checkMin = Math.min(map[i], map[i+1]);
				
				map[i] -= checkMin;
				map[i+1] -= checkMin;
				
				result += checkMin * 5;
			}
			
			if (map[i] != 0) {
				result += 3 * map[i];
				map[i] = 0;	// 결과 도출에 굳이 필요는 없으나 깔끔히 정리
			}
		}
        System.out.println(result);
        br.close();
    }
}