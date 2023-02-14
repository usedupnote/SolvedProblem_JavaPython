import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] num = new int[1001];
		
		int result = 0;
		num[0] = 1;
		num[1] = 1;
		
		for (int j = 2; j <= 1000; j++) {
			int point = 2;
			
			if (num[j] == 0) {
				while (j * point <= 1000) {
					num[j * point] = 1;
					point++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int checknum = sc.nextInt();
			
			if (num[checknum] == 0) {
				result++;
			}
		}
		System.out.println(result);
		
		sc.close();
	}
}