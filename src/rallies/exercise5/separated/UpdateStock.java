package rallies.exercise5.separated;

import java.io.IOException;

import rallies.exercise5.separated.common.FileSystem;
import rallies.exercise5.separated.exception.LoadException;
import rallies.exercise5.separated.model.ErrorList;
import rallies.exercise5.separated.model.ErrorType;
import rallies.exercise5.separated.model.ItemList;
import rallies.exercise5.separated.model.SalesList;


public class UpdateStock {

	/**
	 * メイン処理
	 * @param args コマンドライン引数（指定なし）
	 */
	public static void main(String[] args) {
		
		// 初期化処理
		ItemList itemList = new ItemList();    // 商品マスタ（リスト）
		SalesList salesList = new SalesList(); // 売上データ（リスト）
		ItemList newItemList = new ItemList(); // 新商品マスタ（リスト）
		ErrorList errorList = new ErrorList(); // エラーリスト
		
		try {
			// 商品マスタ読込み
			itemList.getItemsFromCsv(FileSystem.CSV_ITEM_MASTER_PATH);
			// 売上データ読込み
			salesList.getSalesFromCsv(FileSystem.CSV_SALES_DATA_PATH);
			// 在庫数更新処理
			newItemList = itemList.updateStock(salesList, errorList);
			
			// 表示処理：エラーメッセージの表示
			errorList.display();
			// 表示処理：新商品マスタの出力
			newItemList.writeToFile(FileSystem.CSV_NEW_ITEM_MASTER_PATH);			
			// 表示処理：処理件数の表示
			displayProcessedCounts(itemList, newItemList, salesList, errorList);
			
		} catch (LoadException | IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
				
	}

	/**
	 * 各種の処理件数を表示する
	 * @param itemList    商品マスタリスト
	 * @param newItemList 新商品マスタリスト
	 * @param salesList   売上データリスト
	 * @param errorList   エラーメッセージリスト
	 */
	private static void displayProcessedCounts(
			ItemList itemList, 
			ItemList newItemList, 
			SalesList salesList,
			ErrorList errorList) {
		
		// エラー種別エラー数のカウント
		int salesErrorCount = errorList.countByErrorType(ErrorType.SALES_DATA);
		int stockErrorCount = errorList.countByErrorType(ErrorType.STOCK_UPDATE);
		
		// 結果表示
		System.out.println("* * *  処理件数  * * *");
		System.out.println("\t売上データ：" + salesList.count() + " 件");
		System.out.println("\t売上エラー：" + salesErrorCount + " 件");
		System.out.println("\t在庫エラー：" + stockErrorCount + " 件");
		System.out.println("\t商品マスタ：" + itemList.count() + " 件");
		System.out.println("\t新商品マスタ：" + newItemList.count() + " 件");
	}

}
