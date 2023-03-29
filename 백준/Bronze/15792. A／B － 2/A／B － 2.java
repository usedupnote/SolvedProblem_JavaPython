import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		sb.append(A/B + ".");
		
		int cnt = 0;
		
		while (cnt++ < 1000) {
			A %= B;
			A *= 10;
			if(A== 0) break;
			sb.append(A/B);
		}
		System.out.println(sb);
		br.close();
	}
}