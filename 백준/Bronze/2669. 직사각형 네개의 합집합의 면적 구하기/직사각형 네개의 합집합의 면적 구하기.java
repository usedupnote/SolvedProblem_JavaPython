import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int result = 0;
    	boolean[][] v = new boolean[100][100];

    	for (int cnt = 0; cnt < 4; cnt++) {
    		st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		
    		for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					if(v[i][j]) continue;
					result++;
					v[i][j] = true;
				}
			}
    	}
    	
    	System.out.println(result);
    	br.close();
	}
}