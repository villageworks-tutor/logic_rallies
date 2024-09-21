package rallies.exercise5;

public class Sales {

	/**
	 * フィールド
	 */
	private String code;  // 商品コード
	private int price;    // 単価
	private int quantity; // 数量
	private int subTotal; // 金額（小計）
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Sales() {}

	/**
	 * コンストラクタ
	 * @param code     商品コード
	 * @param price    単価
	 * @param quantity 数量
	 * @param subTotal 金額
	 */
	public Sales(String code, int price, int quantity, int subTotal) {
		this.code = code;
		this.price = price;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "Sales [code=" + code + ", price=" + price + ", quantity=" + quantity + ", subTotal=" + subTotal + "]";
	}
	
}
