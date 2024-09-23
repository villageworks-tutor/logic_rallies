package rallies.exercise51.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import rallies.exercise5.separated.common.Messages;
import rallies.exercise5.separated.exception.LoadException;
import rallies.exercise51.bean.Score;

public class ScoreList {
	
	/**
	 * フィールド
	 */
	private List<Score> list = new ArrayList<Score>();

	/**
	 * デフォルトコンストラクタ
	 */
	public ScoreList() {}

	/**
	 * コンストラクタ
	 * @param targetFilePath 読み込むデータファイルのファイルパス
	 * @throws LoadException 
	 */
	public ScoreList(String filePath) throws LoadException {
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				String[] fields = line.split(",");
				String room = fields[0];
				room = room.replaceAll("^\"|\"$", ""); // 文字列の先頭もしくは末尾の「"」を除去
				int english = Integer.parseInt(fields[1]);
				int japanese = Integer.parseInt(fields[2]);
				int math = Integer.parseInt(fields[3]);
				int sci = Integer.parseInt(fields[4]);
				int society = Integer.parseInt(fields[5]);
				Score score = new Score(room, society, english, japanese, math, sci, society);
				this.list.add(score);
			}
			// 商品マスタにレコードがない場合：メッセージを表示して強制終了
			if (this.list.size() == 0) {
				this.list = new ArrayList<Score>();
				throw new LoadException(Messages.ERR_ITEM_RECORD_NOT_FOUND);
			}
			
		} catch (NoSuchFileException e) {
			// 商品マスタファイルが見つからなかった場合：メッセージを表示して強制終了
			// e.printStackTrace();
			throw new LoadException(Messages.ERR_ITEM_FILE_NOT_FOUND);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			
		}
		
	}

	public List<Score> getList() {
		return this.list;
	}
	
	public void setList(List<Score> list) {
		this.list = list;
	}
	
}
