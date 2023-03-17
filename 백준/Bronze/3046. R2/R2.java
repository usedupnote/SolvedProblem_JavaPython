import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int R = Integer.parseInt(st.nextToken());
    	int S = Integer.parseInt(st.nextToken());
    	
    	System.out.println((2 * S) - R);
    	br.close();
	}
}