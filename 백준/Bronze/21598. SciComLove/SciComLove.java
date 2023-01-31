import java.io.*;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws Exception {
		// 기본 설정 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sb.append("SciComLove");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		if (Integer.parseInt(st.nextToken()) != 1) {
			sb.append("\nSciComLove");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}