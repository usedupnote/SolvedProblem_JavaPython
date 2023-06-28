import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			char[] c = br.readLine().toCharArray();
			int cLen = c.length;
			if (cLen==3) {
				if (c[0] == '*' && c[0] == c[1] && c[1] == c[2]) break;
			}
			for (int i = 1; i <= cLen; i++) {
				sb.append(c[cLen-i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}