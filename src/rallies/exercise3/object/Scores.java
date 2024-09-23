package rallies.exercise3.object;

public class Scores {
	
	/**
	 * フィールド
	 */
	private int english;  // 英語の得点
	private int language; // 国語の得点
	private int math;     // 数学の得点
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Scores() {}

	/**
	 * コンストラクタ
	 * @param english  英語の得点
	 * @param language 国語の得点
	 * @param math     数学の得点
	 */
	public Scores(int english, int language, int math) {
		super();
		this.english = english;
		this.language = language;
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Score [english=" + english + ", language=" + language + ", math=" + math + "]";
	}
	
	/**
	 * 合計点を取得する
	 * @return 合計点
	 */
	public int getTotal() {
		return this.english + this.language + this.math;
	}
	
}
