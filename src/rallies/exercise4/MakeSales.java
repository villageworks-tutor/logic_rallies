package rallies.exercise4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeSales {

	public static void main(String[] args) {
		// 初期化処理
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(101, "おいしい牛乳", 148));
		itemList.add(new Item(102, "マンゴジュース", 105));
		itemList.add(new Item(201, "ポテトチップス", 218));
		itemList.add(new Item(202, "チョコレート", 105));
		itemList.add(new Item(301, "食パン", 139));
		itemList.add(new Item(302, "おにぎり", 120));
		itemList.add(new Item(401, "鉛筆", 210));
		itemList.add(new Item(402, "消しゴム", 150));
		itemList.add(new Item(901, "なべ", 1800));
		itemList.add(new Item(902, "フライパン", 3980));
		
		// 商品一覧表示
		System.out.println("* * *  商品一覧  * * *");
		System.out.println("商品コード\t商品名");
		for (Item item : itemList) {
			System.out.println(item.getCode() + "\t" + item.getName());
		}
		// 売上登錄
		List<Sales> salesList = new ArrayList<>(); // 売上リスト初期化
		System.out.println("* * *  売上登錄  * * *");
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				// 商品コード取得
				System.out.print("商品コード：\t");
				int code = scanner.nextInt();
				// 0が入力された場合：登錄処理を中断
				if (code == 0) break;
				
				// 商品取得
				Item existsItem = null;
				for (Item item : itemList) {
					if (code == item.getCode()) {
						existsItem = item;
					}
				}
				if (existsItem == null) {
					System.out.println("該当する商品が見つかりませんでした。再入力してください。");
					continue;
				}
				System.out.print("商品名： " + existsItem.getName() + "\t");
				System.out.println("単価： " + existsItem.getPrice() + " 円");
				System.out.print("数量： ");
				int quantity = scanner.nextInt();
				System.out.println("金額： " + (existsItem.getPrice() * quantity) + " 円");
				// 売上クラスのインスタンス化
				Sales sales = new Sales(code, existsItem.getPrice(), quantity);
				//売上リストに追加
				salesList.add(sales);
			}
		}
		
		// 売上件数表示
		System.out.println("◆売上データを " + salesList.size() + " 件作成しました。");
		// 売上データファイル出力
		try (PrintWriter writer = new PrintWriter("src/rallies/exercise4/sales.csv");) {
			for (Sales sales : salesList) {
				writer.println(sales);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
