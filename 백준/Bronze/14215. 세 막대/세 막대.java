import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;			
		int[] num = new int[3];
		st = new StringTokenizer(br.readLine());
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		num[2] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		int result = num[0] + num[1];
		System.out.println(result+(num[2]>=result?result-1:num[2]));
		br.close();
	}
}