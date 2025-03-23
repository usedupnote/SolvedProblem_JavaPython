import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = Math.min(x, y);

        while (right - left >= 0.001) {
            double width = (left + right) / 2;
            double hx = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2));
            double hy = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2));
            double res = (hx * hy) / (hx + hy);
  
            if (res >= c) left = width;
            else right = width;
        }
        System.out.println(String.format("%.3f", right));
        br.close();
    }
}