import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long V = Integer.parseInt(st.nextToken());
		
		V -= B;
		int ab = A - B;
		long result = V/ab + (V%ab == 0 ? 0 : 1);
		
		System.out.println(result);
		br.close();
	}
}