package rallies.exercise5.separated.model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import rallies.exercise5.separated.bean.Item;
import rallies.exercise5.separated.common.FileSystem;

class ItemListTest {

	/** テスト対象クラス：system under test */
	ItemList sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new ItemList();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("ItemList#getItemsFromCsv(String)メソッドのテストクラス")
	class GetItemsListTest {
		private List<Item> expected = new ArrayList<Item>();
		void setUp() {
			expected.add(new Item("101","おいしい牛乳",148,100));
			expected.add(new Item("102","マンゴジュース",105,100));
			expected.add(new Item("201","ポテトチップス",218,100));
			expected.add(new Item("202","チョコレート",105,100));
			expected.add(new Item("301","食パン",139,100));
			expected.add(new Item("302","おにぎり",120,100));
			expected.add(new Item("401","鉛筆",210,100));
			expected.add(new Item("402","消しゴム",150,100));
			expected.add(new Item("901","なべ",1800,100));
			expected.add(new Item("902","フライパン",3980,100));
		}
		
		@Test
		@DisplayName("Test-03: 商品番号「302」の商品は「おにぎり」のインスタンスである")
		void test03() throws Exception {
			// setup
			String target = "302";
			Item expected = new Item("302","おにぎり",120,100);
			sut.getItemsFromCsv(FileSystem.CSV_ITEM_MASTER_PATH);
			// execute
			Item actual = sut.getItemByCode(target);
			// verify
			assertThat(actual.toString(), is(expected.toString()));
		}

		@Test
		@DisplayName("Test-02: 商品マスタの件数は10件である")
		void test02() throws Exception {
			// setup
			int expected = 10;
			sut.getItemsFromCsv(FileSystem.CSV_ITEM_MASTER_PATH);
			// execute
			int actual = sut.count();
			// verify
			assertThat(actual, is(expected));
		}
		
		@Test
		@DisplayName("Test-01: 商品マスタを読み込む")
		void test01() throws Exception {
			// setup
			String filePath = FileSystem.CSV_ITEM_MASTER_PATH;
			// execute
			sut.getItemsFromCsv(filePath);
			// verify
			List<Item> actual = sut.getList();
			for (int i = 0; i < expected.size(); i++) {
				assertThat(actual.get(i).toString(), is(expected.get(i).toString()));
			}
		}
	}

}
