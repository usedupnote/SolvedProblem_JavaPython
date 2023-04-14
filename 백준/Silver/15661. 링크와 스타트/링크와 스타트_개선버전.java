import java.io.*;
import java.util.*;
 
public class Main {
    private static int N;
    private static int[] sumRow;
    private static int[] sumColumn;
    private static int result = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
        sumRow 	  = new int[N];
        sumColumn = new int[N];

        int sumTotal = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                sumTotal += num;
                sumRow[i] += num;
                sumColumn[j] += num;
            }
        }

        comb(0, 0, sumTotal);
        
        System.out.println(result);
        br.close();
	}

    private static void comb(int index, int cnt, int sumTotal) {
        result = Math.min(result, Math.abs(sumTotal));
        if (index == N || cnt == (N/2) + 1) return;
        comb(index + 1, cnt + 1, sumTotal - sumRow[index] - sumColumn[index]);
        comb(index + 1, cnt, sumTotal);
    }
}