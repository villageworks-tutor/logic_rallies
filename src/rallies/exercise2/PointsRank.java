package rallies.exercise2;

import java.util.Scanner;

public class PointsRank {

	public static void main(String[] args) {
		
		/// ランク名配列の初期化
		String[] ranks = {"Aランク", "Bランク", "Cランク", "Dランク"};
		// ランク別人数の初期化
		int[] countsByRanks = new int[4];
		
		// 点数配列の初期化
		int[] scores = new int[20];
		
		// 入力処理
		try (Scanner scanner = new Scanner(System.in);) {
			for (int i = 0; i < scores.length; i++) {
				System.out.print((i + 1) + "/" + scores.length + "：　");
				scores[i] = scanner.nextInt();
				// エラーチェック：0から100までの整数ではない場合、メッセージを表示して入力待機
				if (!(0 <= scores[i] && scores[i] <= 100)) {
					i--;
					System.out.println("成績は0点以上、100点以下で入力してください");
					continue;
				}
				// ランク別人数の集計
				int rank = getRankByScore(scores[i]);
				countsByRanks[rank]++;
			}
		}
		
		/*
		// ランク別人数の集計
		for (int i = 0; i < scores.length; i++) {
			int rank = -1;
			if (scores[i] >= 85) {
				rank = 0;
			} else if (scores[i] >= 60) {
				rank = 1;
			} else if (scores[i] >= 40) {
				rank = 2;
			} else {
				rank = 3;
			}
			countsByRanks[rank]++;
		}
		*/
		
		// プログラム見出し表示
		System.out.println("* * *  成績ランク別人数  * * *");
		for (int i = 0; i < countsByRanks.length; i++) {
			String stars = createStars(countsByRanks[i]);
			System.out.println(ranks[i] + "：" + stars);
		}

	}

	/**
	 * 指定された数だけ「*」を表示する
	 * @param count 表示する数 
	 * @return 指定された表示数だけ「*」が追加された文字列
	 */
	private static String createStars(int count) {
		String stars = "";
		for (int i = 0; i < count; i++) {
			stars += "*";
		}
		return stars;
	}
	
	/**
	 * スコアによってランクを決める
	 * @param score スコア
	 * @return スコアのポイントによって決まるランク
	 */
	private static int getRankByScore(int score) {
		int rank = -1;
		if (score >= 85) {
			rank = 0;
		} else if (score >= 60) {
			rank = 1;
		} else if (score >= 40) {
			rank = 2;
		} else {
			rank = 3;
		}
		return rank;
	}

}
