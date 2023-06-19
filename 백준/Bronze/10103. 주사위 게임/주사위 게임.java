import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int c = 100;
		int s = 100;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cn = Integer.parseInt(st.nextToken());
			int sn = Integer.parseInt(st.nextToken());
			
			if (cn > sn) s -= cn;	
			else if (cn < sn) c -= sn;
		}
		
		System.out.println(c + "\n" + s);
	}
}