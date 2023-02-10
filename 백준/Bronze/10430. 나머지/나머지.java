import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		sb.append((A+B)%C + "\n" + ((A%C) + (B%C))%C + "\n" + (A*B)%C + "\n" + ((A%C) * (B%C))%C);
		
		System.out.println(sb);
		br.close();
	}
}