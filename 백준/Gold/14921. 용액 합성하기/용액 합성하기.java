import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
		}
        
        int start = 0;
        int end = N - 1;
        
        while (start != end) {
        	int d = nums[end] + nums[start];
			if (d == 0) {
				result = 0;
				break;
			} else if (d > 0) {
				result = Math.abs(result) < d?result:d;
				end--;
			} else {
				result = Math.abs(result) < -d?result:d;
				start++;
			}
		}
        
        System.out.println(result);
        br.close();
	}
}