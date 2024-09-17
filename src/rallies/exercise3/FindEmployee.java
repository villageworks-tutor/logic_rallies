package rallies.exercise3;

import java.util.Scanner;

public class FindEmployee {

	public static void main(String[] args) {
		// 初期処理
		int count = 10;
		int[] idList = new int[count];
		String[] nameList = new String[count];
		String[] departments = new String[count];
		String[] lines = new String[count];
		
		// 入力処理
		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("* * *  社員情報  * * *");
			for (int i = 0; i < count; i++) {
				// 社員番号入力
				System.out.print((i + 1) + "/" + count + " 社員番号：");
				int id = scanner.nextInt();
				// 社員番号に0が入力された場合：ループを中断
				if (id < 1) break;
				// 社員番号を社員番号配列に格納
				idList[i] = id;
				// 社員名入力
				System.out.print((i + 1) + "/" + count + " 名前：");
				String name = scanner.next();
				nameList[i] = name;
				// 部署名入力
				System.out.print((i + 1) + "/" + count + " 部署名：");
				String department = scanner.next();
				departments[i] = department;
				// 内線番号入力
				System.out.print((i + 1) + "/" + count + " 内線番号：");
				String line = scanner.next();
				lines[i] = line;
			}
		}
		
	}

}
