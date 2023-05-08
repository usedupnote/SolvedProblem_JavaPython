import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = 2000, M = 2000;

        for (int i = 0; i < 3; i++) {
        	st = new StringTokenizer(br.readLine());
            N = Math.min(N, Integer.parseInt(st.nextToken()));
		}
        for (int i = 0; i < 2; i++) {
        	st = new StringTokenizer(br.readLine());
            M = Math.min(M, Integer.parseInt(st.nextToken()));
		}
        System.out.println(N + M - 50);
        br.close();
    }
}