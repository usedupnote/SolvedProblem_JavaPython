import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	BigInteger n = new BigInteger(st.nextToken());
    	BigInteger m = new BigInteger(st.nextToken());

    	sb.append(n.divide(m)).append("\n").append(n.remainder(m));
    	System.out.println(sb);
    }
}