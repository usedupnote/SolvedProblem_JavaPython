import java.io.*;
import java.util.*;
 
public class Solution {
    static int N;
    static char[] ch;
    static int pos;
    static char[][] map = new char[100][];
     
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 기본 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

    	
        for (int test_case = 1; test_case <= 10; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	
        	map = new char[100][100];
        	
        	for (int i = 0; i < 100; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < 100; j++) {
        			ch = st.nextToken().toCharArray();
        			map[i][j] = ch[0];
				}
			}
        	
        	for (int i = 0; i < 100; i++) {
        		if (map[99][i] == '2') {
    				pos = i;
    			}	
			}
        	
        	for (int i = 99; i >= 0; i--) {
				if (pos + 1 < 100 && map[i][pos + 1] == '1') {
					while (pos + 1 < 100 && map[i][pos + 1] == '1') {
						pos++;
					}
				} else if (pos - 1 >= 0 && map[i][pos - 1] == '1') {
					while (pos - 1 >= 0 && map[i][pos - 1] == '1') {
						pos--;
					}
				}
			}
        	sb.append("#" + test_case + " " + pos + "\n");
        }
        System.out.println(sb.toString());
    }
}