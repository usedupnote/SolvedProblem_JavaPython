import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	//재료의 개수 N(1 ≤ N ≤ 15,000)
    	st = new StringTokenizer(br.readLine());
    	int N  = Integer.parseInt(st.nextToken());
    	
    	//갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000)
    	st = new StringTokenizer(br.readLine());
    	int M  = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	//갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)
    	int[] num = new int[N];
    	for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
    	Arrays.sort(num);
    	
    	int start = 0, end = N-1;
    	
    	int check = 0;
    	int result = 0;
    	while (start < end) {
			check = num[start] + num[end];
    		if(check==M) {
    			result++;
    			start++;
    			end--;
    			continue;
    		} else if (check > M) {
    			end--;
    			continue;
    		} else {
    			start++;
    			continue;
    		}
		}
    	System.out.println(result);
        br.close();
	}
}