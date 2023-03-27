import java.io.*;
import java.util.*;

public class Main {
	static ArrayDeque<Character>[] q;
	private static void star(int x, int cnt) {
		if(cnt == 1) {
			q[x].offer('*');
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==1 && j==1) {
					for (int k = 0; k < cnt/3; k++) {
						for (int l = 0; l < cnt/3; l++) {
							q[x+(i * cnt/3)+k].offer(' ');
						}
					}
				}else {
					star(x+(i*cnt/3),cnt/3);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque[n];
		
		for (int i = 0; i < n; i++) {
			q[i] = new ArrayDeque<>();
		}
		
		star(0, n);
		
		for (int i = 0; i < n; i++) {
			System.out.println(q[i].toString().replace("[", "").replace("]", "").replace(", ", ""));
		}
		br.close();
	}
}