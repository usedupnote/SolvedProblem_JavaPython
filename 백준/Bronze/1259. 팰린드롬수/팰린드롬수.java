import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] ch = br.readLine().toCharArray();
		
		while (ch[0] != '0') {
			for (int i = 0; i < ch.length; i++) {
				if (ch[i] != ch[ch.length - i - 1]) {
					sb.append("no\n");
					break;
				}
				if (i >= ch.length - i - 1) {
					sb.append("yes\n");
					break;
				}
			}
			ch = br.readLine().toCharArray();
		}
		System.out.println(sb);
		br.close();
	}
}