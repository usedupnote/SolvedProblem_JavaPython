import java.io.*;
import java.util.*;

public class Main {
	static int[] coin = {500,100,50,10,5,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = 1000 - Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i : coin) {
			result += N/i;
			N%=i;
		}
		System.out.println(result);
		br.close();
	}
}