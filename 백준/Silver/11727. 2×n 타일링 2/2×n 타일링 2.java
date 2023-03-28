import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//TestCase 수
		
		int[] map = new int[n+1];
		map[0] = 1; map[1] = 3;
		
		for (int i = 2; i < n; i++) {
			map[i] = (map[i-1] + 2 * map[i-2]) % 10007;
		}
		System.out.println(map[n-1]);
	}
}