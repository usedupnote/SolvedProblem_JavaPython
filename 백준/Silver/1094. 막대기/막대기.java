import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	
	    int X = Integer.parseInt(st.nextToken());
	    
	    int R = 64;
	    int L = 0;
	    int result = 0;
	    
	    while (X != 0) {
			if(X < R) {
				R /= 2;
			} else {
				X -= R;
				R /= 2;
				result++;
			}
		}
	    System.out.println(result);
	}
}