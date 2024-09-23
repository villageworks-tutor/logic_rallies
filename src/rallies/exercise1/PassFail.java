package rallies.exercise1;

import java.util.Scanner;

public class PassFail {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in);) {
			// キーボードから点数を取得
			System.out.print("点数：");
			int score = scanner.nextInt();
			
			// 取得した点数を評価
			String result = "";
			if (score >= 70) {
				result = "合格";
			} else {
				result = "不合格";
			}
			// 結果の表示文字列の生成
			result = "【" + result + "】";
			// 結果の表示
			System.out.println(result);
		}
		
	}

}
