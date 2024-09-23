package rallies.exercise51.model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import rallies.exercise51.bean.Score;

class ScoreTest {

	/** テスト対象クラス：systemm under test */
	Score sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new Score();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("Score#getAllRemarks()メソッドのテストクラス")
	class GetAllRemarksTest {
		@ParameterizedTest
		@MethodSource("paramsProvider")
		@DisplayName("Test: 全科目合計点と全科目平均点を計算できる")
		void test(Score score, double[] expected) {
			// execute
			sut = score;
			double[] actual = sut.getAllRemarks();
			// verify
			assertThat(actual, is(expected));
			
		}
		
		static Stream<Arguments> paramsProvider() {
			// setup
			List<Score> scoreList = new ArrayList<Score>();
			List<double[]> remarksList = new ArrayList<>();
			// Test-01: 英語・国語・数学・理科・社会の得点が「100, 47, 41, 58, 53」のときの全科目の結果成績は「299, 59.8」である
			scoreList.add(new Score("A", 1, 100, 47, 41, 58, 53));
			remarksList.add(new double[]{299, 59.8});
			// テストパラメータを返却
			return Stream.of(Arguments.of(scoreList.get(0), remarksList.get(0)));
		}
		
	}
	
	@Nested
	@DisplayName("Score#getMainRemarks()メソッドのテストクラス")
	class GetMainRemarksTest {
		@ParameterizedTest
		@MethodSource("paramsProvider")
		@DisplayName("Test: 3科目合計点と3科目平均点を計算できる")
		void test(Score score, double[] expected) {
			// execute
			sut = score;
			double[] actual = sut.getMainRemarks();
			// verify
			assertThat(actual, is(expected));
			
		}
		
		static Stream<Arguments> paramsProvider() {
			// setup
			List<Score> scoreList = new ArrayList<Score>();
			List<double[]> remarksList = new ArrayList<>();
			// Test-01: 英語・国語・数学・理科・社会の得点が「100, 47, 41, 58, 53」のときの3科目の結果成績は「188, 62.7」である
			scoreList.add(new Score("A", 1, 100, 47, 41, 58, 53));
			remarksList.add(new double[]{188, 62.7});
			// テストパラメータを返却
			return Stream.of(Arguments.of(scoreList.get(0), remarksList.get(0)));
		}
		
	}

}
