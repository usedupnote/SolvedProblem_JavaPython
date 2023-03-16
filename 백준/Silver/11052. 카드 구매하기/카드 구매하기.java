import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int[] num = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    		for (int j = 0; j < i; j++) {
				num[i] = Math.max(num[i], num[j] + num[i - j - 1]);
			}
		}
    	System.out.println(num[N-1]);
    	br.close();
	}
}