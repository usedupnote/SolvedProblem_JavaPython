import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());	//접시의 수 N (2 ≤ N ≤ 3,000,000)
        int d = Integer.parseInt(st.nextToken());	//초밥의 가짓수 d (2 ≤ d ≤ 3,000)
        int k = Integer.parseInt(st.nextToken());	//연속해서 먹는 접시의 수 k (2 ≤ k ≤ 3,000 (k ≤ N))
        int c = Integer.parseInt(st.nextToken());	//쿠폰 번호 c (1 ≤ c ≤ d)
        
        //두 번째 줄부터 N개의 줄에는 벨트의 한 위치부터 시작하여 회전 방향을 따라갈 때
        //초밥의 종류를 나타내는 1 이상 d 이하의 정수가 각 줄마다 하나씩 주어진다. 
        int[] rail = new int[N];
        for (int i = 0; i < N; i++) {
        	rail[i] = Integer.parseInt(br.readLine());	// 초밥 레일의 상태
		}
        
        int cnt = 1;
        int[] v = new int[d+1];
        v[c]++;
        for (int i = 0; i < k; i++) {
        	if(v[rail[i]] == 0) cnt++;
        	v[rail[i]]++;
		}
        
        int result = cnt;
        
        for (int i = 0; i < N; i++) {
        	v[rail[i]]--;
        	if(v[rail[i]] == 0) cnt--;
        	if(v[rail[(i+k)%N]] == 0) cnt++;
        	v[rail[(i+k)%N]]++;
        	result = Math.max(result, cnt);
		}
        
        System.out.println(result);
    }
}