import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int cnt = 1;
        for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				sb.append(cnt++).append(" ");
			}
			sb.append(cnt++).append("\n");
		}
    	
        System.out.println(sb);
        br.close();
    }
}