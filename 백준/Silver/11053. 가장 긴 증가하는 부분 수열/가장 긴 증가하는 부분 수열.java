import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, max, arr[i]);
			if(temp < 0) temp = Math.abs(temp) -1;
			LIS[temp] = arr[i];
			if(max == temp) max++;
		}
		System.out.println(max);
	}
}