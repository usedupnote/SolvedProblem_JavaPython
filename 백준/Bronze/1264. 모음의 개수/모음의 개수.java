import java.io.*;
import java.util.*;

public class Main {
	static char[] odd = {'a','e','i','o','u'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			char[] ch = br.readLine().toLowerCase().toCharArray();
			
			if(ch[0] == '#') break;
			
			int cnt = 0;
			for (char c : ch) {
				for (int i = 0; i < 5; i++) {
					if (c == odd[i]) {
						cnt++; break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}