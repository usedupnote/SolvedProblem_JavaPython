import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	char[] ch = st.nextToken().toCharArray();
    	int chLen = ch.length;
    	int result = chLen * 5 + 5;
    	
    	for (int i = 1; i < chLen; i++) {
			if (ch[i] != ch[i-1]) result+=5;
		}
    	
    	System.out.println(result);
    }
}