package rallies.exercise5.separated.bean;

public interface ICsv {
	/**
	 * すべてのフィールドをcsv形式の文字列として取得する
	 * @return すべてのフィールドをカンマ区切りで結合した文字列
	 */
	public String getCsvValue();
}
