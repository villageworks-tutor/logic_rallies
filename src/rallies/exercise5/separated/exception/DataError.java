package rallies.exercise5.separated.exception;

import rallies.exercise5.separated.bean.ICsv;

public class DataError {
	
	/**
	 * フィールド
	 */
	private ErrorType type; // エラー種別
	private int order;      // エラー発生レコードの位置
	private ICsv target;    // エラー発生レコード
	
	/**
	 * デフォルトコンストラクタ
	 */
	public DataError() {}

	/**
	 * コンストラクタ
	 * @param type   エラー種別
	 * @param order  エラー発生レコードの位置
	 * @param target エラー発生レコード
	 */
	public DataError(ErrorType type, int order, ICsv target) {
		this.type = type;
		this.order = order;
		this.target = target;
	}
	
	public ErrorType getType() {
		return this.type;
	}
	
	/**
	 * エラー表示用メッセージを取得する
	 * @return エラー表示用メッセージ
	 */
	public String getMeassage() {
		StringBuffer buffer = new StringBuffer();
		
		switch (this.type) {
		case SALES_DATA:
			buffer.append("売上データエラー");
			break;
		case STOCK_UPDATE:
			buffer.append("在庫更新エラー");
			break;
		default:
			buffer.append("未定義エラー");
			break;
		}
		
		buffer.append("（" + this.order + "）：");
		buffer.append(this.target.getCsvValue());
		
		return buffer.toString();
	}	
	
}
