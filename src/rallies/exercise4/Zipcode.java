package rallies.exercise4;

public class Zipcode {

	/**
	 * フィールド
	 */
	private String zipcode;    // 郵便番号
	private String prefecture; // 都道府県名
	private String city;       // 市区町村名
	private String town;       // 町域
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Zipcode() {}

	/**
	 * コンストラクタ
	 * @param zipcode    郵便番号
	 * @param prefecture 都道府県名
	 * @param city       市区町村名
	 * @param town       町域
	 */
	public Zipcode(String zipcode, String prefecture, String city, String town) {
		this.zipcode = zipcode;
		this.prefecture = prefecture;
		this.city = city;
		this.town = town;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return this.prefecture + "\t" + this.city + "\t" + this.town;
	}
	
}
