import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int team = ((N/2 > M) ? M:N/2);

        N -= team * 2;
        M -= team;
        
        K -= N + M;
        
        if(K > 0) {
        	team -= (K + 2) / 3;
        }
        System.out.println(team);
        br.close();
    }
}