import java.io.*;
import java.util.*;

public class Main {		    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        br.readLine();
        char[] ch = br.readLine().toCharArray();
        char[] check = {'a','e','i','o','u'};

        int result = 0;
        
        for(char c : ch) {   
            for(char com : check) {
                if (c == com) {
                    result++;
                    break;
                }
            }     
        }
        
        System.out.print(result);
	}
}
