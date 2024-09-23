package rallies.exercise2;

public class GroupTotal {

	public static void main(String[] args) {
		
		// 初期化処理
		// 分類テーブルの準備：分類コードは配列インデックスに1加算したものとする
		String[] categories = {"お菓子", "飲料", "食品", "文具", "その他"};
		// 売上データの準備：分類コードは配列インデックスに1加算したものとする
		int[] salesCategories = {2, 3, 1, 1, 4, 2, 5, 1, 3, 2, 1, 4, 1, 1, 2, 3, 2, 1, 3, 1};
		int[] salesAmount = {115, 475, 1423, 300, 500, 1980, 14070, 57, 568, 98, 630, 480, 2480, 260, 168, 678, 540, 236, 298, 120};
		
		// 集計処理
		// 分類別売上合計の初期化
		int[] salesTotalByCategory = new int[categories.length];
		// 総合計の初期化
		int total = 0;
		// 集計
		for (int i = 0; i < salesCategories.length; i++) {
			int category = salesCategories[i] - 1;
			salesTotalByCategory[category] += salesAmount[i];
			total += salesAmount[i];
		}
		
		// 表示処理
		System.out.println("* * *  分類別売上集計  * * *");
		System.out.println("処理件数： " + salesAmount.length + " 件");
		for (int i = 0; i < salesTotalByCategory.length; i++) {
			System.out.println(categories[i] + "： " + salesTotalByCategory[i] + " 円");
		}
		System.out.println("売上計： " + total + " 円");
		
	}

}
