package rallies.exercise3;

public class SortNum {

	public static void main(String[] args) {
		// 初期化処理
		int[] sources = {35, 96, 30, 26, 77, 45, 81, 44, 3, 28};
		// 並替え前の状態表示
		System.out.println("* * *  ソート前  * * *");
		for (int source : sources) {
			System.out.print(source + " ");
		}
		
		System.out.println("\n");
		
		// 並替え処理
		for (int i = sources.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				// 逆順の場合：入れ替える
				if (sources[j] > sources[j+1]) {
					int temp = sources[j];
					sources[j] = sources[j+1];
					sources[j+1] = temp;
				}
			}
		}
		
		// 並替え後の状態表示
		System.out.println("* * *  ソート後  * * *");
		for (int source : sources) {
			System.out.print(source + " ");
		}
		
	}

}
