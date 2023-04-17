import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken()) * 100;
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(N>=M?"Yes":"No");
	}
}