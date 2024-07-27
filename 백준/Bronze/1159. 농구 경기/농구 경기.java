import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] charCounter = new int[26];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            charCounter[st.nextToken().toCharArray()[0] - 'a']++;
		}
        
        for (int i = 0; i < 26; i++) {
        	if (charCounter[i] > 4) {
        		sb.append((char)(i + 'a'));
			}
		}
        if (sb.length() == 0) {
			sb.append("PREDAJA");
		}
        
        System.out.println(sb);
        
        br.close();
    }
}