import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int T = Integer.parseInt(st.nextToken());
	    
	    for (int TC = 1; TC <= T; TC++) {
	    	st = new StringTokenizer(br.readLine());
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x2 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken());
		    
		    st = new StringTokenizer(br.readLine());
		    int n = Integer.parseInt(st.nextToken());
		    
		    int cnt = 0;

		    int cx,cy,r,des1,des2,check;
		    
		    for (int i = 0; i < n; i++) {
		    	st = new StringTokenizer(br.readLine());
		    	cx = Integer.parseInt(st.nextToken());
		    	cy = Integer.parseInt(st.nextToken());
		    	r  = Integer.parseInt(st.nextToken());
		    	r *= r;
		    	
		    	des1 = ((x1-cx) * (x1-cx)) + ((y1-cy) * (y1-cy));
		    	des2 = ((x2-cx) * (x2-cx)) + ((y2-cy) * (y2-cy));
		    	check = 0;
		    	if(des1 < r) check++;
		    	if(des2 < r) check++;
		    	if(check == 1) cnt++;
			}
		    sb.append(cnt).append("\n");
		}
	    System.out.println(sb);
	    br.close();
	}
}