import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<ArrayList<String>> stack = new ArrayList();
		
		for (int i = 0; i < 201; i++) {
			stack.add(new ArrayList<String>());
		}
		
		int age;
		String name;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			stack.get(age).add(name);
		}
		
		for (int i = 0; i < 201; i++) {
			while (!stack.get(i).isEmpty()) {
				String poll = stack.get(i).remove(0);
				sb.append(i + " " + poll + "\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}