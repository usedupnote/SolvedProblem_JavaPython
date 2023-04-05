import java.io.*;
import java.util.*;
 
public class Solution {
    static final int INF = 99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        //테스트케이스의 개수 T(1 ≤ T ≤ 15)
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
         
        for (int TC = 1; TC <= T; TC++) {
            //학생들의 수 N(2 ≤ N ≤ 500)
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
             
            //두 학생의 키를 비교한 횟수 M(0 ≤ M ≤ N*(N-1)/2)
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
 
            int[][] map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i], INF);
            }
             
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                //두 학생의 키를 비교한 결과를 나타내는 두 양의 정수 a, b
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                map[a][b] = 1;
            }
             
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
             
            int result = 0;
            for (int i = 0; i < N; i++) {
                int cnt = 1;
                for (int j = 0; j < N; j++) {
                    if(i==j) continue;
                    if((map[i][j] & map[j][i]) != INF) {
                        cnt++;
                        continue;
                    }
                    break;
                }
                if(cnt == N) result++;
            }
            //자신이 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지를 출력
            sb.append("#").append(TC).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}