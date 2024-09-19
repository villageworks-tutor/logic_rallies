package rallies.exercise4;

public class Sales {
	
	/**
	 * フィールド
	 */
	private int code;     // 商品コード
	private int price;    // 単価
	private int quantity; // 数量
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Sales() {}

	/**
	 * コンストラクタ
	 * @param code     商品コード
	 * @param price    単価
	 * @param quantity 数量
	 */
	public Sales(int code, int price, int quantity) {
		this.code = code;
		this.price = price;
		this.quantity = quantity;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
		return this.price * this.quantity;
	}

	@Override
	public String toString() {
		return this.code + ", " + this.price + ", " + this.quantity + ", " + (this.price * this.quantity);
	}
	
}
