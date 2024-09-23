package rallies.exercise5.separated.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {

	/**
	 * フィールド
	 */
	private List<DataError> list = new ArrayList<DataError>(); // エラーメッセージリスト

	/**
	 * デフォルトコンストラクタ
	 */
	public ErrorList() {}

	/**
	 * エラーメッセージリストを取得する
	 * @return 商品リスト
	 */
	public List<DataError> getList() {
		return this.list;
	}
	
	/**
	 * エラーメッセージリストに商品を追加する
	 * @param target 追加するエラーメッセージ
	 */
	public void add(DataError target) {
		this.list.add(target);
	}
	
	/**
	 * エラーメッセージリストのエラーメッセージインスタンスの個数を取得する
	 * @return 商品リストの商品インスタンスの個数
	 */
	public int count() {
		return this.list.size();
	}
	
	/**
	 * 指定されたエラー種別のエラーメッセージの個数を取得する
	 * @param type エラー種別
	 * @return エラー種別のエラーメッセージの個数
	 */
	public int countByErrorType(ErrorType type) {
		int count = 0;
		for (DataError error : this.list) {
			if (error.getType() == type) {
				count++;
			}
		}
		return count;
	}

	public void display() {
		for (DataError error : this.list) {
			System.out.println(error.getMeassage());
		}
	}
	
}
