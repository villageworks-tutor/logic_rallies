package rallies.exercise1;

import java.util.Scanner;

public class CalcChange {

	public static void main(String[] args) {
		
		// スキャナオブジェクトの取得：キーボードからの入力値を受け取るツール
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// 価格の入力
		System.out.print("金額：");
		int price = scanner.nextInt();
		// 預り金の入力
		System.out.print("預り金：");
		int pay = scanner.nextInt();
		// 釣銭の計算
		int change = pay - price;
		// 釣銭の表示
		System.out.println("おつりは " + change + " 円です。");
		
		// スキャナオブジェクトの解放
		scanner = null;		

	}

}
