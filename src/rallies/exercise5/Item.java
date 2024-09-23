package rallies.exercise5;

public class Item {

	/**
	 * フィールド
	 */
	private String code; // 商品コード
	private String name; // 商品名
	private int price;   // 単価
	private int stock;   // 在庫数
	
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
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return this.code + "," + this.name + "," + this.price + "," + this.stock;
	}
	
}
