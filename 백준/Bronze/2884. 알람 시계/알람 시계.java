import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken()) - 45;
		
		hour = hour - (min < 0 ? 1 : 0);
		
		hour = hour < 0 ? 24 + hour : hour;
		min = min < 0 ? 60 + min : min;
		
		sb.append(hour).append(" ").append(min);
		
		System.out.println(sb);
		
		br.close();
	}
}