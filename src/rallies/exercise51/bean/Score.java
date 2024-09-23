package rallies.exercise51.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import rallies.exercise51.model.Subject;

public class Score {
	
	/**
	 * クラス定数
	 */
	private static final int ROUND_BIT = 1; // 四捨五入して小数点以下の桁を揃えるときの桁数
	
	/**
	 * フィールド
	 */
	private String room;                                  // クラス名
	private int id;                                       // 出席番号
	private Map<Subject, Integer> list = new HashMap<>(); // スコアリスト
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Score() {}

	/**
	 * コンストラクタ
	 * @param room     クラス名
	 * @param id       出席番号
	 * @param english  英語の得点
	 * @param japanese 国語の得点
	 * @param math     数学の得点
	 * @param sci      理科の得点
	 * @param society  社会の得点
	 */
	public Score(
			String room, int id, 
			int english, int japanese, int math, int sci, int society) {
		super();
		this.room = room;
		this.id = id;
		this.list.put(Subject.ENGLISH, english);
		this.list.put(Subject.JAPANESE , japanese);
		this.list.put(Subject.MATH, math);
		this.list.put(Subject.SCI, sci);
		this.list.put(Subject.SOCIETY, society);
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnglish() {
		return this.list.get(Subject.ENGLISH);
	}

	public void setEnglish(int english) {
		this.list.put(Subject.ENGLISH, english);
	}

	public int getJapanese() {
		return this.list.get(Subject.JAPANESE);
	}

	public void setJapanese(int japanese) {
		this.list.put(Subject.JAPANESE, japanese);
	}

	public int getMath() {
		return this.list.get(Subject.MATH);
	}

	public void setMath(int math) {
		this.list.put(Subject.MATH, math);
	}

	public int getSci() {
		return this.list.get(Subject.SCI);
	}

	public void setSci(int sci) {
		this.list.put(Subject.SCI, sci);
	}

	public int getSociety() {
		return this.list.get(Subject.SOCIETY);
	}

	public void setSociety(int society) {
		this.list.put(Subject.SOCIETY, society);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Score [");
		buffer.append("room=" + room + ", ");
		buffer.append("id=" + id + ", ");
		buffer.append("english=" + this.list.get(Subject.ENGLISH) + ", ");
		buffer.append("japanese=" + this.list.get(Subject.JAPANESE) + ", ");
		buffer.append("math=" + this.list.get(Subject.MATH) + ", ");
		buffer.append("sci=" + this.list.get(Subject.SCI) + ", ");
		buffer.append("society=" + this.list.get(Subject.SOCIETY) + "]");
		return buffer.toString();
	}

	/**
	 * 3科目の成績を計算する
	 * @return 合計と平均点を要素とするdouble型の配列
	 */
	public double[] getMainRemarks() {
		return this.getRemarks(false);
	}
	
	/**
	 * 5科目の成績を計算する
	 * @return 合計と平均点を要素とするdouble型の配列
	 */
	public double[] getAllRemarks() {
		return this.getRemarks(true);
	}
	
	/**
	 * 得点の合計を計算する
	 * @param isAllTotal 5科目の集計の場合はtrue、それ以外はfalse
	 * @return 合計と平均点を要素とするdouble型の配列
	 */
	private double[] getRemarks(boolean isAllTotal) {
		// 合計点の計算：英語・国語・数学の合計は必ず計算
		double count = 3d;
		int total = 0;
		total += this.list.get(Subject.ENGLISH);
		total += this.list.get(Subject.JAPANESE);
		total += this.list.get(Subject.MATH);
		
		// 5科目の場合
		if (isAllTotal) {
			count = 5d;
			total += this.list.get(Subject.SCI);
			total += this.list.get(Subject.SOCIETY);
		}
		
		// 平均点の計算
		double average = total / count;
		average = this.roundHalfUp(ROUND_BIT, average);
		
		// 戻り値の生成
		double[] remarks = new double[2];
		remarks[0] = total;
		remarks[1] = average;
		
		// 戻り値を返却
		return remarks;
	}
	
	/**
	 * 指定された桁の浮動小数に四捨五入する
	 * @param bit    揃える小数点以下の桁数
	 * @param target 四捨五入対象となる浮動小数
	 * @return 桁が揃えられた浮動小数点数
	 */
	private double roundHalfUp(int bit, double target) {
		BigDecimal decimal = new BigDecimal(target);
		return decimal.setScale(bit, RoundingMode.HALF_UP).doubleValue();
	}
	
}
