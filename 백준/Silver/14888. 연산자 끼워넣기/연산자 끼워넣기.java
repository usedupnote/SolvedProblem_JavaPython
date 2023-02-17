import java.io.*;
import java.util.*;

public class Main {
	static int N, resultMax, resultMin;
	static int[] num;
	static int[] oper;	// [0 : +] [1 : -] [2 : *] [3 : /]
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		oper = new int[N-1];
		
		resultMax = Integer.MIN_VALUE;
		resultMin = Integer.MAX_VALUE;
		
		// 숫자 설정
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 설정 (전처리인 오름차순 정렬이 된 상태로 진행)
		int pos = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			
			while (count != 0) {
				count--;
				oper[pos++] = i;
			}
		}
		
		do {
			int[] compare = num.clone();
			for (int i = 0; i < N - 1; i++) {
				switch (oper[i]) {
				case 0:
					compare[i + 1] = compare[i] + compare[i + 1];
					break;
				case 1:
					compare[i + 1] = compare[i] - compare[i + 1];
					break;
				case 2:
					compare[i + 1] = compare[i] * compare[i + 1];
					break;
				default:
					compare[i + 1] = compare[i] / compare[i + 1];
					break;
				}
			}
			resultMax = Integer.max(resultMax, compare[N-1]);
			resultMin = Integer.min(resultMin, compare[N-1]);
		} while (np(oper));
		
		System.out.println(resultMax + "\n" + resultMin);
		br.close();
	}

	private static boolean np(int[] input) {
		int n = input.length;

		
		//step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기바로 앞이 교환할 자리)
		int i = n-1;
		while (i>0 && input[i-1]>= input[i]) --i;
		if(i==0) return false;
		
		//step2. 꼭대기 바로 앞(i-1) 자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while (input[i-1] >= input[j]) --j;
		
		// step3. 꼭대기 바로 앞(i-1) 자리와 그 자리값보다 한단계 큰 자리 (j) 수와 비교
		swap(input, i-1, j);
		
		// step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n-1;
		while (i < k) swap(input, i++, k--);
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		input[i] += input[j];
		input[j] = input[i] - input[j];
		input[i] -= input[j];
	}
}