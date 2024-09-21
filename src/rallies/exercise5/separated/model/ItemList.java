package rallies.exercise5.separated.model;

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
import rallies.exercise5.separated.common.Messages;
import rallies.exercise5.separated.exception.LoadException;

public class ItemList {

	/**
	 * フィールド
	 */
	private List<Item> list = new ArrayList<Item>(); // 商品リスト

	/**
	 * デフォルトコンストラクタ
	 */
	public ItemList() {}
	
	/**
	 * 商品リストを取得する
	 * @return 商品リスト
	 */
	public List<Item> getList() {
		return this.list;
	}
	
	/**
	 * 商品リストに商品を追加する
	 * @param target 追加する商品インスタンス
	 */
	public void add(Item target) {
		this.list.add(target);
	}
	
	/**
	 * 商品リストの商品インスタンスの個数を取得する
	 * @return 商品リストの商品インスタンスの個数
	 */
	public int count() {
		return this.list.size();
	}
	
	/**
	 * 指定された商品コードの商品を取得する
	 * @param code 取得する商品の商品コード
	 * @return 指定された商品コードと合致する商品がある場合は商品インスタンス、それ以外はnull
	 */
	public Item getItemByCode(String code) {
		for (Item item : this.list) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}
	
	/**
	 * csv形式のファイルから商品リストを取得する
	 * @param filePath 取得する対象csvファイルのファイルパス
	 * @throws LoadException 読込時例外（ユーザ定義例外）
	 * @throws IOException
	 */
	public void getItemsFromCsv(String filePath) throws LoadException, IOException {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				String[] fields = line.split(",");
				String code = fields[0];
				String name = fields[1];
				int price = Integer.parseInt(fields[2]);
				int stock = Integer.parseInt(fields[3]);
				Item item = new Item(code, name, price, stock);
				this.list.add(item);
			}
			// 商品マスタにレコードがない場合：メッセージを表示して強制終了
			if (this.list.size() == 0) {
				throw new LoadException(Messages.ERR_ITEM_RECORD_NOT_FOUND);
			}
			
		} catch (NoSuchFileException e) {
			// 商品マスタファイルが見つからなかった場合：メッセージを表示して強制終了
			// e.printStackTrace();
			throw new LoadException(Messages.ERR_ITEM_FILE_NOT_FOUND);
		}
		
	}

	/**
	 * うろ揚げデータリストをもとに商品マスタリストの在庫数を更新する
	 * @param salesList 売上データリスト
	 * @param errorList エラーメッセージリスト
	 * @return 商品マスタにない商品が売上データリストに記載されている商品の新商品マスタリスト
	 */
	public ItemList updateStock(SalesList salesList, ErrorList errorList) {
		// 戻り値である新商品マスタリストを初期化
		ItemList newItemList = new ItemList();
		
		// 売上データ件数カウンタを初期化
		int  count = 0;
		
		// 売上データリストのすべての売上を走査
		for (Sales sales : salesList.getList()) {
			// 売上データ件数をカウントアップ
			count++;
			// 商品インスタンスを習得：商品マスタのすべての商品を走査して現在読み込んでいる売上に対応する商品を検索
			Item target = null;
			for (Item item : this.list) {
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
				errorList.add(new DataError(ErrorType.SALES_DATA, count, newItem));
				// 次の売上データのループに遷移
				continue;
			}
			// 在庫数を比較
			int newStock = target.getStock() - sales.getQuantity();
			
			// 在庫数の書換
			if (newStock < 0) {
				// 新在庫が負の整数になる場合：0で書き換えて在庫更新エラーに追加
				target.setStock(0);
				errorList.add(new DataError(ErrorType.STOCK_UPDATE, count, sales));
			} else {
				// 新在庫が正の整数である場合：新在庫で書換
				target.setStock(newStock);
			}
			
		}
		return newItemList;
	}

	/**
	 * 商品マスタリストをファイルにcsv形式で出力する
	 * @param filePath 出力先ファイルのファイルパス
	 * @throws FileNotFoundException 
	 */
	public void writeToFile(String filePath) throws FileNotFoundException {
		// 新商品マスタファイルに新商品マスタデータを書き込む
		try (PrintWriter writer = new PrintWriter(filePath);) {
			for (Item item : this.getList()) {
				writer.println(item.getCsvValue());
			}
		}
	}
	
}
