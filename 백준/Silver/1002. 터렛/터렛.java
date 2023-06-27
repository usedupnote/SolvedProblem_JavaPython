import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		long x1,y1,r1,x2,y2,r2, dest, pr;
		
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			x1 = Long.parseLong(st.nextToken());
			y1 = Long.parseLong(st.nextToken());
			r1 = Long.parseLong(st.nextToken());
			x2 = Long.parseLong(st.nextToken());
			y2 = Long.parseLong(st.nextToken());
			r2 = Long.parseLong(st.nextToken());
			
			dest = ((x1-x2) * (x1-x2)) + ((y1-y2)*(y1-y2));
			pr = (r1 + r2) * (r1 + r2);
            if	(r1==0) sb.append(1);
			else if	(x1==x2 && y1==y2 && r1==r2) sb.append(-1);
			else if (pr < dest || (r1 - r2) * (r1 - r2) > dest) sb.append(0);
			else if (pr == dest || (r1 - r2) * (r1 - r2) == dest) sb.append(1);
			else sb.append(2);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}