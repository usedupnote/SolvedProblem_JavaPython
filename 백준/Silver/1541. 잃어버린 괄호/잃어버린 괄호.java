import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] ch =  br.readLine().toCharArray();
        
        long cnt = 1, check = 0, result = 0;
        
        for (int i = ch.length - 1; i >= 0 ; i--) {
			if(ch[i] == '+') {
				cnt = 1;
			} else if (ch[i] == '-') {
				result -= check;
				check = 0;
				cnt = 1;
			} else {
				check += (ch[i] - '0') * cnt;
				cnt *= 10;
			}
		}
        result += check;
        System.out.println(result);
    }
}
