package rallies.exercise5.separated;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import rallies.exercise5.separated.bean.Item;
import rallies.exercise5.separated.bean.Sales;


public class UpdateStock {

	/**
	 * クラス定数
	 */
	private static final String FILE_PATH = "src/rallies/exercise5/";
	private static final String CSV_ITEM_MASTER_PATH = FILE_PATH + "item.csv";
	private static final String CSV_SALES_DATA_PATH = FILE_PATH + "sales.csv";
	private static final String CSV_NEW_ITEM_MASTER_PATH = FILE_PATH + "separated/newItem.csv";
	
	private static final String ERR_SALES_FILE_NOT_FOUND = "売上データ(sales.csv)が見つかりません。";
	private static final String ERR_ITEM_FILE_NOT_FOUND = "商品マスタ（item.csv）が見つかりません。";
	private static final String ERR_ITEM_RECORD_NOT_FOUND = "商品マスタにレコードがありません。";
	
	/**
	 * メイン処理
	 * @param args コマンドライン引数（指定なし）
	 */
	public static void main(String[] args) {
		// 初期化処理
		List<Item> itemList = new ArrayList<>();        // 商品マスタ（リスト）
		List<Sales> salesList = new ArrayList<>();      // 売上データ（リスト）
		List<Item> newItemList = new ArrayList<>();     // 新商品マスタ（リスト）
		List<String> errorList = new ArrayList<>();     // エラーリスト
		
		// 商品マスタ読込み
		itemList = loadItemMaster(CSV_ITEM_MASTER_PATH);
		
		// 売上データ読込み
		salesList = loadSales(CSV_SALES_DATA_PATH);
				
		// 在庫数更新処理
		newItemList = updateStock(salesList, itemList, errorList);
		
		// 表示処理：エラーメッセージの表示
		displayErrorMesages(errorList);
		// 表示処理：新商品マスタの出力
		writeToMasterFile(CSV_NEW_ITEM_MASTER_PATH, newItemList);
		
		// 表示処理：処理件数の表示
		System.out.println("* * *  処理件数  * * *");
		System.out.println("\t売上データ：" + salesList.size() + " 件");
		System.out.println("\t売上エラー：" + errorList.size() + " 件");
		System.out.println("\t在庫データ：" + errorList.size() + " 件");
		System.out.println("\t商品マスタ：" + itemList.size() + " 件");
		System.out.println("\t新商品マスタ：" + newItemList.size() + " 件");
	}

	/**
	 * 新商品マスタリストをファイルに書き込む
	 * @param filePath 新商品マスタファイルのファイルパス
	 * @param newItemList 新商品マスタリスト
	 */
	private static void writeToMasterFile(String filePath, List<Item> newItemList) {
		filePath = "src/rallies/exercise5/newItem.csv";
		try (PrintWriter writer = new PrintWriter(filePath);) {
			for (Item item : newItemList) {
				writer.println(item.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * エラーメッセージを表示する
	 * @param errorList エラーメッセージリスト
	 */
	private static void displayErrorMesages(List<String> errorList) {
		for (String error : errorList) {
			System.out.println(error);
		}
	}

	/**
	 * 在庫数を更新する
	 * @param salesList 売上データリスト
	 * @param itemList  商品マスタリスト
	 * @param errorList エラーメッセージリスト
	 * @return 新商品マスタリスト
	 */
	private static List<Item> updateStock(
			List<Sales> salesList, 
			List<Item> itemList, 
			List<String> errorList) {
		// 戻り値であるエラーメッセージリストを初期化
		List<Item> newItemList = new ArrayList<Item>();
		
		// 売上データ件数カウンタを初期化
		int  count = 0;
		
		// 売上データリストのすべての売上を走査
		for (Sales sales : salesList) {
			// 売上データ件数をカウントアップ
			count++;
			// 商品インスタンスを習得：商品マスタのすべての商品を走査して現在読み込んでいる売上に対応する商品を検索
			Item target = null;
			for (Item item : itemList) {
				// 売上データの商品コードと一致する商品が見つかったらその商品を退避して走査を中断
				if (item.getCode().equals(sales.getCode())) {
					target = item; // 一致した商品の退避
					break;
				}
			}
			// 商品インスタンスの存在によって処理を分岐：退避した商品がnullであれば売上の商品コードと一致する商品がなかったことになる
			if (target == null) {
				// 新規商品のインスタンス化：商品名はnullのまま（あるいは「商品名未定」と設定しても可）
				Item newItem = new Item();
				newItem.setCode(sales.getCode());
				newItem.setPrice(sales.getPrice());
				newItem.setStock(sales.getQuantity());
				// 新規商品の登錄
				newItemList.add(newItem);
				// 売上データエラーの追加
				errorList.add("売上データエラー（" + count + "）：" + newItem.toString());
				// 次の売上データのループに遷移
				continue;
			}
			// 在庫数を比較
			int newStock = target.getStock() - sales.getQuantity();
			
			// 在庫数の書換
			if (newStock < 0) {
				// 新在庫が負の整数になる場合：0で書き換えて在庫更新エラーに追加
				target.setStock(0);
				errorList.add("在庫更新エラー（" + count + "）：" + sales.toString());
			} else {
				// 新在庫が正の整数である場合：新在庫で書換
				target.setStock(newStock);
			}
			
		}
		
		// 新商品マスタリストを返却
		return newItemList;
		
	}

	/**
	 * 指定されたファイルパスの売上データファイルを読み込む
	 * @param filePath  売上データファイルのファイルパス
	 * @param salesList 売上データリスト
	 */
	private static List<Sales> loadSales(String filePath) {
		// 戻り値である売上データリストを初期化
		List<Sales> salesList = new ArrayList<Sales>();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
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
			System.err.println(ERR_SALES_FILE_NOT_FOUND);
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// 売上データリストを返却
		return salesList;
		
	}

	/**
	 * 指定されたファイルパスの商品マスタを読み込む
	 * @param filePath 商品マスタファイルのファイルパス
	 * @param itemList 商品マスタリスト
	 */
	private static List<Item> loadItemMaster(String filePath) {
		// 戻り値である商品マスタリストを初期化
		List<Item> itemList = new ArrayList<Item>();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
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
				System.err.println(ERR_ITEM_RECORD_NOT_FOUND);
				System.exit(-1);
			}
			
		} catch (NoSuchFileException e) {
			// 商品マスタファイルが見つからなかった場合：メッセージを表示して強制終了
			// e.printStackTrace();
			System.err.println(ERR_ITEM_FILE_NOT_FOUND);
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// 商品マスタリストを返却
		return itemList;
		
	}
	
}
