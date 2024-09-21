package rallies.exercise3.object;

import java.util.Scanner;

public class SortStudent {

	public static void main(String[] args) {
		// 初期化処理
		int inputCount = 0;
		int upperCount = 20;
		Student[] students = new Student[upperCount];
		
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
				// 生徒名の取得
				System.out.print((i + 1) + "/" + upperCount + " 名前：");
				String name = scanner.next();
				// 英語の得点の取得
				System.out.print((i + 1) + "/" + upperCount + " 英語：");
				int english =scanner.nextInt();
				//　国語の得点を取得
				System.out.print((i + 1) + "/" + upperCount + " 国語：");
				int language = scanner.nextInt();
				// 数学の得点の取得
				System.out.print((i + 1) + "/" + upperCount + " 数学：");
				int math = scanner.nextInt();
				// 生徒のインスタンス化
				Student student = new Student(id, name, english, language, math);
				
				// 生徒配列に生成したインスタンスを格納
				students[i] = student;
			}
		}
		// 並替え処理
		for (int i = 0; i < inputCount; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (students[j].getTotal() >= students[j + 1].getTotal()) {
					break;
				}
				// 並替えの実行
				Student studentTemp = null;
				// 生徒の並べ替え
				studentTemp = students[j];
				students[j] = students[j+1];
				students[j+1] = studentTemp;
			}
		}
		
		// 表示処理
		System.out.println("***  ソート後  ***");
		System.out.println("No\t名前\t合計\t英語\t国語\t数学");
		for (Student student : students) {
			// 要素がnullなら終了：studentsをListにすることでこの処理は不要とできる
			if (student == null) break;
			// データの表示
			System.out.print(student.getId() + "\t");
			System.out.print(student.getName() + "\t");
			System.out.print(student.getTotal() + "\t");
			System.out.print(student.getEnglish() + "\t");
			System.out.print(student.getLanguage() + "\t");
			System.out.print(student.getMath() + "\n");
		}
		
	}

}
