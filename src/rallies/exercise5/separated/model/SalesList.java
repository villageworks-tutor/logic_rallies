package rallies.exercise5.separated.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import rallies.exercise5.separated.bean.Sales;
import rallies.exercise5.separated.common.Messages;
import rallies.exercise5.separated.exception.LoadException;

public class SalesList {
	/**
	 * フィールド
	 */
	private List<Sales> list = new ArrayList<>(); // 売上データリスト

	/**
	 * デフォルトコンストラクタ
	 */
	public SalesList() {}
	
	/**
	 * 売上データリストを取得する
	 * @return 売上データリスト
	 */
	public List<Sales> getList() {
		return this.list;
	}
	
	/**
	 * 売上データリストに売上を追加する
	 * @param target 追加する売上インスタンス
	 */
	public void add(Sales target) {
		this.list.add(target);
	}

	/**
	 * 売上データリストの売上インスタンスの個数を取得する
	 * @return 売上データリストの売上インスタンスの個数
	 */
	public int count() {
		return this.list.size();
	}
	
	/**
	 * csv形式のファイルから売上データリストを取得する
	 * @param filePath 取得する対象csvファイルのファイルパス
	 * @throws LoadException 読込時例外（ユーザ定義例外）
	 * @throws IOException
	 */
	public void getSalesFromCsv(String filePath) throws LoadException, IOException {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				String[] fields = line.split(",");
				String code = fields[0];
				int price = Integer.parseInt(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				int subTotal = Integer.parseInt(fields[3]);
				Sales sales = new Sales(code, price, quantity, subTotal);
				this.list.add(sales);
			}
		} catch (NoSuchFileException e) {
			// 売上データファイルが見つからなかった場合：メッセージを表示して強制終了
			// e.printStackTrace();
			throw new LoadException(Messages.ERR_SALES_FILE_NOT_FOUND);
		}
		
	}
	
}
