package algo.data.table.impl;

import org.junit.Assert;

import algo.data.table.Table;

public class TableTest {
	public static void main(String[] args) {
		Table table = new LinkedHashTable();

		Assert.assertEquals(0, table.size());

		String key1 = "key1";
		String key2 = "key2";
		String key3 = "key3";
		String value1 = "value of key1";
		String value2 = "value of key2";
		String value3 = "value of key3";
		table.put(key1, value1);
		table.put(key2, value2);
		table.put(key3, value3);

		Assert.assertEquals(3, table.size());

		Assert.assertEquals(value1, table.get(key1));
		Assert.assertEquals(value2, table.get(key2));
		Assert.assertEquals(value3, table.get(key3));
		Assert.assertNull(table.get("unknown"));

		table.remove(key2);

		Assert.assertEquals(2, table.size());
		Assert.assertNull(table.get(key2));

		// test for a lot of table keys
		for (int i = 0; i < 120; i++) {
			table.put("key" + i, i);
		}
	}
}
