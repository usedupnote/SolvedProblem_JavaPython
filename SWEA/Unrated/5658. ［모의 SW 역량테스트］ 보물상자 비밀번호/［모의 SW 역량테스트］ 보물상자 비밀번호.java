import java.io.*;
import java.util.*;
 
public class Solution {
    static final int[] dirX = {-1, 0, 1, 0};    // 상 우 하 좌
    static final int[] dirY = {0, 1, 0, -1};
    static int N, K;
    static int[][] map;
     
    static Set<Integer> list;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());       // 숫자의 개수 N (8 ≤ N ≤ 28, 4의 배수)
            K = Integer.parseInt(st.nextToken());       // 크기 순서 K
            
            char[] ch = br.readLine().toCharArray();
            
            list = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                String hexInput = "";
                for (int j = 0; j < N/4; j++) {
                    hexInput += Character.toString(ch[(i + j) % N]);
                }
                list.add(Integer.parseInt(hexInput,16));
            }
            sb.append("#" + test_case + " " + list.toArray()[list.size() - K] + "\n");
        }
        System.out.println(sb);
        br.close();
 
    }
}