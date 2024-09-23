package rallies.exercise51;

import rallies.exercise5.separated.exception.LoadException;
import rallies.exercise51.bean.Score;
import rallies.exercise51.model.ScoreList;

public class ListClassRecords {
	
	private static final String TARGET_FILE_PATH = "src/rallies/exercise51/seiseki.csv";
	
	public static void main(String[] args) {
		try {
			// 初期処理
			ScoreList scores = new ScoreList(TARGET_FILE_PATH);
			
			// クラス別成績一覧表の作成
			String roomBuffer = "";
			for (Score score : scores.getList()) {
				if (score.getRoom().equals(roomBuffer)) {
					System.out.println(score.getRoom());
				} else {
					System.out.println("\n");
					roomBuffer = score.getRoom();
				}
			}
			
			// 終了処理
			
		} catch (LoadException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

}
