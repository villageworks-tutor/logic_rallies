package rallies.exercise1;

import java.util.Scanner;

public class CountsPoint {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			// 合計点と平均点の初期化
			int total = 0;
			double average = 0;
			// 点数配列の準備
			int[] scores = new int[10];
			// 点数の入力
			int i = 0;
			/* whileでもforでもどちらでも構わない
			while (i < scores.length) {
				System.out.print((i + 1) + "/" + scores.length + "：");
				int score = scanner.nextInt();
				if (score < 0) {
					break;
				}
				total += score;
				i++;
			}
			*/
			for (i = 0; i < scores.length; i++) {
				System.out.print((i + 1) + "/" + scores.length + "：");
				scores[i] = scanner.nextInt();
				if (scores[i] < 0) {
					break;
				}
				total += scores[i];
			}
			
			// 平均点の計算
			average = (double) total / i;
			// 結果の表示
			System.out.println("人数：" + i + "人");
			System.out.println("合計点：" + total + "点");
			System.out.println("平均点：" + average + "点");
		}
	}

}
