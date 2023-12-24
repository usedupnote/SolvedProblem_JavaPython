import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	String[] curTS = st.nextToken().split(":");
    	
    	st = new StringTokenizer(br.readLine());
    	String[] regTS = st.nextToken().split(":");

    	int curT = getTime(curTS);
    	int regT = getTime(regTS);
    	
    	int returnTime = 0;
    	
    	if (curT > regT) returnTime += 24 * 60 * 60;
    	returnTime += regT - curT;

    	String h = setTimeForm(returnTime/(60*60));
    	String m = setTimeForm((returnTime%(60*60))/60);
    	String s = setTimeForm(returnTime%60);

    	sb.append(h).append(":").append(m).append(":").append(s);
    	System.out.println(sb);
    }

	private static Integer getTime(String[] T) {
		int time = 0;
		time += (Integer.parseInt(T[0])) * 60 * 60;
		time += (Integer.parseInt(T[1])) * 60;
		time += (Integer.parseInt(T[2]));
		return time;
	}

	private static String setTimeForm(int i) {
		if (i < 10) {
			return "0" + Integer.toString(i);
		}
		return Integer.toString(i);
	}
}