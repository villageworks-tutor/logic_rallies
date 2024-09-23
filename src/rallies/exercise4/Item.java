package rallies.exercise4;

public class Item {
	
	/**
	 * フィールド
	 */
	private int code;    // 商品コード
	private String name; // 商品名
	private int price;   // 単価
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Item() {}

	/**
	 * コンストラクタ
	 * @param code  商品コード
	 * @param name  商品名
	 * @param price 単価
	 */
	public Item(int code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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

	@Override
	public String toString() {
		return "Item [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
}
