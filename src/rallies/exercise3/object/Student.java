package rallies.exercise3.object;

public class Student {
	
	/**
	 * フィールド
	 */
	private int id;        // 出席番号（学籍番号）
	private String name;   // 生徒名
	private Scores scores; // 得点
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Student() {}

	/**
	 * コンストラクタ
	 * @param id       出席番号（学籍番号）
	 * @param name     生徒名
	 * @param english  英語の得点
	 * @param language 国語の得点
	 * @param math     数学の得点
	 */
	public Student(int id, String name, int english, int language, int math) {
		super();
		this.id = id;
		this.name = name;
		this.scores = new Scores(english, language, math);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnglish() {
		return this.scores.getEnglish();
	}

	public void setEnglish(int english) {
		this.scores.setEnglish(english);
	}

	public int getLanguage() {
		return this.scores.getLanguage();
	}

	public void setLanguage(int language) {
		this.scores.setLanguage(language);
	}

	public int getMath() {
		return this.scores.getMath();
	}

	public void setMath(int math) {
		this.scores.setMath(math);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", scores=" + scores.toString() + "]";
	}
	
	/**
	 * 得点の合計を取得する
	 * @return 得点の合計
	 */
	public int getTotal() {
		return this.scores.getTotal();
	}
	
}
