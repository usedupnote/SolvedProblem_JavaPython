import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int[] result = new int[N + 1];

    	result[0] = 1;
    	result[1] = 2;
    	
    	for (int i = 2; i < N; i++) {
    		result[i] = (result[i-1] + result[i-2]) % 15746;
		}
        System.out.println(result[N-1]);
        br.close();
    }
}