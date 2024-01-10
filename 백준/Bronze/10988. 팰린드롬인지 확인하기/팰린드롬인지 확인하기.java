import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	char[] ch = br.readLine().toCharArray();
    	int l = ch.length;
    	int result = 1;
    	
    	for (int i = 0; i < l/2; i++) {
			if (ch[i] != ch[l-i-1]) {
				result = 0;
				break;
			}
		}
    	System.out.println(result);
    }
}