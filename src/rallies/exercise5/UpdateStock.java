package rallies.exercise5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class UpdateStock {

	public static void main(String[] args) {
		// 初期化処理
		List<Item> itemList = new ArrayList<>();        // 商品マスタ（リスト）
		List<Sales> salesList = new ArrayList<>();      // 売上データ（リスト）
		List<Item> newItemList = new ArrayList<>();     // 新商品マスタ（リスト）
		List<String> errorList = new ArrayList<>();     // エラーリスト
		
		String filePath = "";
		List<String> lines = new ArrayList<>();
		
		// 商品マスタ読込み
		try {
			filePath = "src/rallies/exercise5/item.csv";
			lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				String[] fields = line.split(",");
				String code = fields[0];
				String name = fields[1];
				int price = Integer.parseInt(fields[2]);
				int stock = Integer.parseInt(fields[3]);
				Item item = new Item(code, name, price, stock);
				itemList.add(item);
			}
			// 商品マスタにレコードがない場合：メッセージを表示して強制終了
			if (itemList.size() == 0) {
				System.err.println("商品マスタにレコードがありません。");
				System.exit(-1);
			}
		} catch (NoSuchFileException e) {
			// 商品マスタファイルが見つからなかった場合：メッセージを表示して強制終了
			// e.printStackTrace();
			System.err.println("商品マスタ（item.csv）が見つかりません。");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// 売上データ読込み
		try {
			filePath = "src/rallies/exercise5/sales.csv";
			lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				String[] fields = line.split(",");
				String code = fields[0];
				int price = Integer.parseInt(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				int subTotal = Integer.parseInt(fields[3]);
				Sales sales = new Sales(code, price, quantity, subTotal);
				salesList.add(sales);
			}
		} catch (NoSuchFileException e) {
			// 売上データファイルが見つからなかった場合：メッセージを表示して強制終了
			// e.printStackTrace();
			System.err.println("売上データ(sales.csv)が見つかりません。");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// 照合処理
		int  count = 0;
		for (Sales sales : salesList) {
			count++;
			// 商品インスタンスを習得
			Item existsItem = null;
			for (Item item : itemList) {
				if (item.getCode().equals(sales.getCode())) {
					existsItem = item;
					break;
				}
			}
			// 商品インスタンスの存在によって処理を分岐
			if (existsItem == null) {
				// 新規商品のインスタンス化
				Item newItem = new Item();
				newItem.setCode(sales.getCode());
				newItem.setPrice(sales.getPrice());
				newItem.setStock(sales.getQuantity());
				// 新規商品の登錄
				newItemList.add(newItem);
				// 売上データエラーの追加
				errorList.add("売上データエラー（" + count + "）：" + newItem.toString());
				// 次の売上データに遷移
				continue;
			}
			// 在庫数を比較
			int newStock = existsItem.getStock() - sales.getQuantity();
			
			// 在庫数の書換
			if (newStock < 0) {
				// 新在庫が負数になる場合：0で書き換えて在庫更新エラーに追加
				existsItem.setStock(0);
				errorList.add("在庫更新エラー（" + count + "）：" + sales.toString());
			} else {
				// 新在庫が正数である場合：新在庫で書換
				existsItem.setStock(newStock);
			}
			
		}
		
		// 表示処理
		// エラーメッセージの表示
		for (String error : errorList) {
			System.out.println(error);
		}
		// 新商品マスタの出力
		filePath = "src/rallies/exercise5/newItem.csv";
		try (PrintWriter writer = new PrintWriter(filePath);) {
			for (Item item : newItemList) {
				writer.println(item.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// 処理件数の表示
		System.out.println("* * *  処理件数  * * *");
		System.out.println("\t売上データ：" + salesList.size() + " 件");
		System.out.println("\t売上エラー：" + errorList.size() + " 件");
		System.out.println("\t在庫データ：" + errorList.size() + " 件");
		System.out.println("\t商品マスタ：" + itemList.size() + " 件");
		System.out.println("\t新商品マスタ：" + newItemList.size() + " 件");
	}
	
}
