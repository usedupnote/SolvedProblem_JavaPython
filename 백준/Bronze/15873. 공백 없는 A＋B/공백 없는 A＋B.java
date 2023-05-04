import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
    	int result = 0;
    	for (int i = ch.length - 1; i >= 0; i--) {
			if (ch[i] == '0') result += ((ch[--i] - '0') * 10);
			else              result += ch[i] - '0';
		}
        System.out.println(result);
        br.close();
    }
}