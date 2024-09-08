package samples;

import java.util.Scanner;

class sumA2B {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			// 入力処理
			System.out.print("整数A：");
			int a = scanner.nextInt();
			System.out.print("整数B：");
			int b = scanner.nextInt();
			// 入換処理
			if ( a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			// ２値間集計
			int sum = 0;
			int i = a;
			// 集計ループ
			while (i <= b) {
				sum = sum + i;
				i++;
			}
			System.out.println("整数 " + a + " から整数 " + b + " までの合計は " + sum + " です。");
		}
	}
}