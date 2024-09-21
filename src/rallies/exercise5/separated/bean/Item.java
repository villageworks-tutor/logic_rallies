package rallies.exercise5.separated.bean;

public class Item extends BaseItem implements ICsv {
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Item() {}
	
	/**
	 * コンストラクタ
	 * @param code  商品コード
	 * @param name  商品名
	 * @param price 単価
	 * @param stock 在庫数
	 */
	public Item(String code, String name, int price, int stock) {
		super(code, name, price, stock);
	}

	@Override
	public String getCsvValue() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getCode() + ",");
		buffer.append(this.getName() + ",");
		buffer.append(this.getPrice() + ",");
		buffer.append(this.getStock());
		return buffer.toString();
	}
}
