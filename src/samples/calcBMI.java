package samples;

import java.util.Scanner;

class calcBMI {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			// 入力処理
			System.out.print("身長は（m）？：");
			float height = scanner.nextFloat();
			System.out.print("体重は（kg）？：");
			float weight = scanner.nextFloat();
			// BMIの算出
			float bmi = weight / (height * height);
			// 結果の表示
			System.out.println("BMI指数は " + bmi + " です。");
		}
		
	}
}