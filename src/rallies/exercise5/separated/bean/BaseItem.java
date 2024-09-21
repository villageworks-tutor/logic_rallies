package rallies.exercise5.separated.bean;

public class BaseItem {

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
	public BaseItem() {}

	/**
	 * コンストラクタ
	 * @param code  商品コード
	 * @param name  商品名
	 * @param price 単価
	 * @param stock 在庫数
	 */
	public BaseItem(String code, String name, int price, int stock) {
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
		StringBuffer buffer = new StringBuffer();
		buffer.append("BaseItem [");
		buffer.append("code=" + code + ", ");
		buffer.append("name=" + name + ", ");
		buffer.append("price=" + price + ", ");
		buffer.append("stock=" + stock + "]");
		return buffer.toString();
	}
	
}
