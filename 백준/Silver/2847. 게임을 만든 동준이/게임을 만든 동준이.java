import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] scores = new int[N];
        
        int result = 0;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	scores[i] = Integer.parseInt(st.nextToken());
		}
        
        for (int i = N-1; i > 0; i--) {
        	if (scores[i-1] >= scores[i]) {
        		result += scores[i-1] - scores[i] + 1;
        		scores[i-1] = scores[i] - 1;
			}
		}
        System.out.println(result);
        br.close();
    }
}