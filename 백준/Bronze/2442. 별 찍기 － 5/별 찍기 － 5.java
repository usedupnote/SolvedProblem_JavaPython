import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        for (int i = N-1; i >= 0; i--){
        	for (int j = 0; j < i; j++) {
        		sb.append(" ");
			}
			for (int j = 0; j < 2 * (N-i) - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
        
        System.out.println(sb);
        br.close();
    }
}