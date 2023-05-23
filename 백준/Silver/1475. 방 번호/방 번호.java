import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10];
		while (N>0) {
			num[N%10]++;
			N/=10;
		}
		num[6] = (num[6] + num[9] + 1)/2;

        int max = 0;
		for (int i = 0; i < 9; i++) {
			max = Math.max(max, num[i]);
		}
		System.out.println(max);
	}
}