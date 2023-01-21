import java.io.*;
import java.util.*;

// 풀기는 풀었는데 너무 별로로 풀었다 다시 풀 예정

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int position = 0;
		int point = 1;
		int[] list = new int[N];
		int[] result = new int[N];
		
		for (int i = 0; i < N; i++) list[i] = i+1;
		
		for (int i = 0; i < N; i++) {
			while (point < K) {			
				position = (position + 1) % N;
				
				if (list[position] != 0) point++;
				
			}
			
			result[i] = list[position];
			list[position] = 0;
			point = 0;
		}

		String testString = Arrays.toString(result).replace("[", "<").replace("]",">");
		System.out.println(testString);
	}
}