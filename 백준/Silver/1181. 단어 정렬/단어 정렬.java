import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	int n = Integer.parseInt(br.readLine());
    	
    	TreeSet<String> q = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					if (o1.equals(o2)) {
						return 0;
					}
					char[] char_o1 = o1.toCharArray();
					char[] char_o2 = o2.toCharArray();
					
					for (int i = 0 ; i < char_o1.length ; i++) {
						if (char_o1[i] == char_o2[i]) {
							continue;
						}
						return Integer.compare(char_o1[i], char_o2[i]);
					}
				}
				return Integer.compare(o1.length(), o2.length());
			}
		});
    	
    	for (int i = 0; i < n; i++) {
			String s = br.readLine();
			q.add(s);
		}
    	
    	while (!q.isEmpty()) {
    		sb.append(q.pollFirst()).append("\n");
    	}
    	System.out.println(sb);
    }
}