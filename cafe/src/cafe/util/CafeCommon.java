package cafe.util;

import java.util.Scanner;

public class CafeCommon {
	static Scanner scanner = new Scanner(System.in);
	
	public static int nextInt(String text) {
//		System.out.print(text);
		int tmp = 0;
		int i = 0;
		do {
			try {
				tmp = Integer.parseInt(nextLine(text));
				i = 1;
			} catch (NumberFormatException e) {
				System.out.println("입력이 올바르지 않습니다.");
			}
		} while (i == 0);
		return tmp;
	}
	
	public static String nextLine(String text) {
		System.out.print(text);
		return scanner.nextLine(); // 입력받은거 내보내기

	}
	
}
