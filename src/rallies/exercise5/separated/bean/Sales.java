package rallies.exercise5.separated.bean;

public class Sales extends BaseSales implements ICsv {

	/**
	 * デフォルトコンストラクタ
	 */
	public Sales() {}
	
	/**
	 * コンストラクタ
	 * @param code     商品コード
	 * @param price    単価
	 * @param quantity 数量
	 * @param subTotal 金額（小計）
	 */
	public Sales(String code, int price, int quantity, int subTotal) {
		super(code, price, quantity, subTotal);
	}

	@Override
	public String getCsvValue() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getCode() + ",");
		buffer.append(this.getPrice() + ",");
		buffer.append(this.getQuantity() + ",");
		buffer.append(this.getSubTotal());
		return buffer.toString();
	}
	
}
