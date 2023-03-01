import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int T = Integer.parseInt(st.nextToken());
	    
	    int even = 0;
	    int odd = 0;
	    
	    st = new StringTokenizer(br.readLine());
	    for (int tree = 0; tree < T; tree++) {
	    	int N = Integer.parseInt(st.nextToken());
	    	even += N / 2;
	    	odd  += N % 2;
	    }
	    
	    if(even > odd) {
	    	int check = (even - odd) / 3;
	    	
	    	even -= check;
	    	odd += check * 2;
	    }
	    System.out.println(even == odd ? "YES":"NO");
	    br.close();
	}
}