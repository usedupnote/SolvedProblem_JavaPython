import java.io.*;
import java.util.*;

public class Main {
	static int team;
	static int kim;
	static int im;
	static int count;
	
	static void tonument(int A, int B) {
		if (A == B) return;

		count++;
		tonument(A/2, B/2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		team = Integer.parseInt(st.nextToken());
		kim = Integer.parseInt(st.nextToken()) - 1;
		im = Integer.parseInt(st.nextToken()) - 1;
		
		tonument(kim, im);
		System.out.println(count);
	}
}