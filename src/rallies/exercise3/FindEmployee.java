package rallies.exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rallies.exercise3.object.Employee;

public class FindEmployee {

	public static void main(String[] args) {
		// 初期処理
		int count = 10; // 入力最大人数
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try (Scanner scanner = new Scanner(System.in);) {
			// 入力処理
			System.out.println("* * *  社員情報  * * *");
			// 社員クラスのインスタンス化
			Employee employee = null;
			for (int i = 0; i < count; i++) {
				// 社員のインスタンス化
				employee = new Employee();
				// 社員番号入力
				System.out.print((i + 1) + "/" + count + " 社員番号：");
				int id = scanner.nextInt();
				// 社員番号に0が入力された場合：ループを中断
				if (id < 1) break;
				
				// 社員番号を社員番号配列に格納
				employee.setId(id);
				// 社員名入力
				System.out.print((i + 1) + "/" + count + " 名前：");
				String name = scanner.next();
				employee.setName(name);
				// 部署名入力
				System.out.print((i + 1) + "/" + count + " 部署名：");
				String department = scanner.next();
				employee.setDepartment(department);
				// 内線番号入力
				System.out.print((i + 1) + "/" + count + " 内線番号：");
				String line = scanner.next();
				employee.setLine(line);
				// 社員リストに追加
				employeeList.add(employee);
			}
		
			// 検索処理
			System.out.println("* * *  社員検索  * * *");
			int searchKey = 0;
			// 検索ループ
			while (true) {
				// 検索社員番号の取得
				System.out.print("社員番号？：");
				searchKey = scanner.nextInt();
				// 検索社員番号が0が入力されていた場合：プログラム終了
				if (searchKey == 0) {
					break;
				}
				
				// 探索ループ
				Employee existsEmployee = null;
				for (Employee person : employeeList) {
					// 検索社員番号と社員番号が一致した場合
					if (searchKey == person.getId()) {
						existsEmployee = person;
						break;
					}
				}
				
				// 検索結果表示
				if (existsEmployee == null) {
					// 該当する社員が見つからなかった場合
					System.out.println("\t該当する社員は見つかりませんでした");
				} else {
					// 該当する社員が見つかった場合
					System.out.println("\t部署名：" + existsEmployee.getDepartment());
					System.out.println("\t名前：" + existsEmployee.getName());
					System.out.println("\t内線番号：" + existsEmployee.getLine());
				}
				
			}
			
		}
		
	}

}
