import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
    	int N = Integer.parseInt(br.readLine());

        while (N != 0) {
        	sb.append(cnt++).append(". ").append(N%2==0?"even":"odd").append(" ").append(N/2).append("\n");
        	N = Integer.parseInt(br.readLine());
		}
        
        System.out.println(sb);
        br.close();
    }
}