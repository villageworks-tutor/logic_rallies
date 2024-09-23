package rallies.exercise51.model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import rallies.exercise51.bean.Score;

class ScoreListTest {

	/** テスト対象クラス：system under test */
	ScoreList sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new ScoreList();
	}

	@Nested
	@DisplayName("ScoreList#constructor()のテストクラス")
	class Constructor {
		static final String TARGET_FILE_PATH = "test/rallies/exercise51/model/scores.csv";
		@BeforeEach
		void setUp () throws Exception {
			sut = new ScoreList(TARGET_FILE_PATH);
		}
		
		@ParameterizedTest
		@MethodSource("paramsProvider")
		void test02(String targetRoom, int expected) {
			// setup
			String previousRoom = "";
			int count = 0;  // 要素計数用のカウンタ
			int actual = 0; // 実行値
			// execute
			for (Score score : sut.getList()) {
				count++;
				if (!score.getRoom().equals(previousRoom)) {
					if (previousRoom.equals(targetRoom)) {
						actual = count;
					}
					count = 0;
					previousRoom = score.getRoom();
				}
			}
			// verify
			assertThat(actual, is(expected));
		}
		
		static Stream<Arguments> paramsProvider() {
			// setup
			List<String> targetRooms = new ArrayList<String>();
			List<Integer> expecteds = new ArrayList<Integer>();
			// Test-02.1: クラスAのスコア件数は1件である
			targetRooms.add("A");
			expecteds.add(1);
			// Test-02.2: クラスBのスコア件数は2件である
			targetRooms.add("B");
			expecteds.add(2);
			// Test-02.2: クラスCのスコア件数は5件である
			targetRooms.add("C");
			expecteds.add(5);
			// Test-02.2: クラスDのスコア件数は2件である
			targetRooms.add("D");
			expecteds.add(2);
			// テスト用パラメータの返却
			return Stream.of(
						  Arguments.of(targetRooms.get(0), expecteds.get(0))
						, Arguments.of(targetRooms.get(1), expecteds.get(1))
						, Arguments.of(targetRooms.get(2), expecteds.get(2))
						, Arguments.of(targetRooms.get(3), expecteds.get(3))
					);
		}
		
		@Test
		@DisplayName("Test-01: クラスはA、B、C、Dの４種類ある")
		void test01() {
			// setup
			List<String> expected = new ArrayList<String>();
			expected.add("A");
			expected.add("B");
			expected.add("C");
			expected.add("D");
			// execute
			String buffer = "";
			List<String> actual = new ArrayList<String>();
			for (Score score : sut.getList()) {
				if (!score.getRoom().equals(buffer)) {
					actual.add(score.getRoom());
					buffer = score.getRoom();
				}
			}
			// verify
			for (int i = 0; i < expected.size(); i++) {
				assertThat(actual.get(i), is(expected.get(i)));
			}
		}
		@Test
		@DisplayName("Test-00: ScoreListをインスタンス化できる")
		void test00() {
			// verify
			assertThat(sut, is(instanceOf(ScoreList.class)));
		}
	}

}
