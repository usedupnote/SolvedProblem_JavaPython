import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;			
		
		int num, result = 0;
		
		for (int i = 0; i < 5; i++) {
			num = Integer.parseInt(br.readLine());
			if (num < 40) num = 40;
			result += num;
		}
		System.out.println(result/5);
		br.close();
	}
}