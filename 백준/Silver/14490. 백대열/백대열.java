import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine().replace(":", " "));

    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	for (int i = 2; i <= Integer.min(n, m); i++) {
			if (n % i != 0) continue;
			if (m % i != 0) continue;
			
			n /= i;
			m /= i;
			i--;
		}
    	System.out.println(n+":"+m);
    }
}