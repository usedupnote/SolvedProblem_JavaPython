import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int attendance = 0;
		
		int[] attendanceNum = new int[31];
		
		for (int i = 0; i < 28; i++) {
			attendance = sc.nextInt();
			
			attendanceNum[attendance] = 1;
		}
		
		for (int i = 1; i < attendanceNum.length; i++) {
			if (attendanceNum[i] != 1) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}