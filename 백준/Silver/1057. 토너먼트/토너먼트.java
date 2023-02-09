import java.io.*;
import java.util.*;

public class Main {
	static int team, kim, im;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		team = Integer.parseInt(st.nextToken());
		kim = Integer.parseInt(st.nextToken()) - 1;
		im = Integer.parseInt(st.nextToken()) - 1;
		
		while (kim != im) {
			count += 1;
			kim /= 2;
			im /= 2;
		}
		System.out.println(count);
	}
}