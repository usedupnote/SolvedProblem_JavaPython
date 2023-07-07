import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long R = 2;
		for (int i = 0; i < N; i++) {
			R += R-1;
		}
		System.out.println(R * R);
	}
}
