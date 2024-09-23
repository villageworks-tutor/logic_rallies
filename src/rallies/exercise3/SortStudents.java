package rallies.exercise3;

import java.util.Scanner;

public class SortStudents {

	public static void main(String[] args) {
		// 初期化処理
		int inputCount = 0;
		int upperCount = 20;
		int[] idList = new int[upperCount];
		String[] names = new String[upperCount];
		int[] language = new int[upperCount];
		int[] math = new int[upperCount];
		int[] english = new int[upperCount];
		int[] total = new  int[upperCount];
		
		// 入力処理
		System.out.println("* * *  生徒情報  * * *");
		try (Scanner scanner = new Scanner(System.in)) {
			// 入力人数
			for (int i = 0; i < upperCount; i++) {
				System.out.print((i + 1) + "/" + upperCount + " 出席番号：");
				int id = scanner.nextInt();
				// 出席番号として0が入力された場合：ループを脱出
				if (id < 1) {
					inputCount = i;
					break;
				}
				// 出席番号リストに格納
				idList[i] = id;
				// 生徒名の取得
				System.out.print((i + 1) + "/" + upperCount + " 名前：");
				names[i] = scanner.next();
				// 英語の得点の取得
				System.out.print((i + 1) + "/" + upperCount + " 英語：");
				english[i] =scanner.nextInt();
				//　国語の得点を取得
				System.out.print((i + 1) + "/" + upperCount + " 国語：");
				language[i] = scanner.nextInt();
				// 数学の得点の取得
				System.out.print((i + 1) + "/" + upperCount + " 数学：");
				math[i] = scanner.nextInt();
				// 合計の取得
				total[i] = english[i] + language[i] + math[i];
			}
		}
		// 並替え処理
		for (int i = 0; i < inputCount; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (total[j] >= total[j + 1]) {
					break;
				}
				// 並替えの実行
				int intTemp = 0;
				String strTemp = "";
				// 出席番号の並べ替え
				intTemp = idList[j];
				idList[j] = idList[j+1];
				idList[j+1] = intTemp;
				// 生徒名の並べ替え
				strTemp = names[j];
				names[j] = names[j+1];
				names[j+1] = strTemp;
				// 英語の並べ替え
				intTemp = english[j];
				english[j] = english[j+1];
				english[j+1] = intTemp;
				// 国語の並替え
				intTemp = language[j];
				language[j] = language[j+1];
				language[j+1] = intTemp;
				// 数学の並べ替え
				intTemp = math[j];
				math[j] = math[j+1];
				math[j+1] = intTemp;
				// 合計の並べ替え
				intTemp = total[j];
				total[j] = total[j+1];
				total[j+1] = intTemp;
			}
		}
		
		// 表示処理
		System.out.println("***  ソート後  ***");
		System.out.println("No\t名前\t合計\t英語\t国語\t数学");
		for (int i = 0; i < inputCount; i++) {
			System.out.print(idList[i] + "\t");
			System.out.print(names[i] + "\t");
			System.out.print(total[i] + "\t");
			System.out.print(english[i] + "\t");
			System.out.print(language[i] + "\t");
			System.out.print(math[i] + "\n");
		}
		
	}

}
