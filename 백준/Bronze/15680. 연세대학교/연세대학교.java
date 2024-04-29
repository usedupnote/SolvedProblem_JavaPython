import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt((st.nextToken()));
        System.out.println(N==0?"YONSEI":"Leading the Way to the Future");
        br.close();
    }
}