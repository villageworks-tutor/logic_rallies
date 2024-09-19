package rallies.exercise4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindZIPcode {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			// 初期化処理
			String filePath = "src/rallies/exercise4/ZIPcode.csv";
			List<Zipcode> zipcodeList = new ArrayList<Zipcode>();
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				String[] fields = line.split(",");
				Zipcode zipcode = new Zipcode(fields[0], fields[1], fields[2], fields[3]);
				zipcodeList.add(zipcode);
			}
			
			// 検索ループ
			while (true) {
				// 検索キー入力
				System.out.print("郵便番号（７桁）？：");
				String searchKey = scanner.next();
				// 検索キーが7桁の数字列でない場合
				if (!searchKey.matches("\\d{7}")) {
					// 0が入力された場合：プログラムを終了
					if (searchKey.equals("0")) {
						break;
					}
					System.out.println("郵便番号は7桁の数字で入力してください。");
				}
				
				// 郵便番号検索
				List<Zipcode> resultList = new ArrayList<Zipcode>();
				for (Zipcode zipcode : zipcodeList) {
					if (zipcode.getZipcode().equals(searchKey)) {
						resultList.add(zipcode);
					}
				}
				
				// 郵便番号情報処理
				if (resultList.size() == 0) {
					// 郵便番号が見つからなかった場合：メッセージを表示して入力待機
					System.out.println("該当する郵便番号が見つかりませんでした。");
				} else {
					// 郵便番号が見つかった場合：該当する郵便番号をすべて表示
					for (Zipcode zipcode : resultList) {
						System.out.println("\t" + zipcode);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

}
