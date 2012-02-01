package algo.data;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HashTable {
	private int size = 0;
	private int capacity = 100;
	private Integer[] indexes = new Integer[capacity];
	private List<LinkedList<Entry>> data = new LinkedList<LinkedList<Entry>>();

	private int hash(Object key) {
		int code = key.hashCode();

		return (int) (Math.abs(code) / 2f / Integer.MAX_VALUE * capacity);
	}

	public Object get(String key) {
		int h = hash(key);

		if (indexes[h] == null) {
			return null;
		} else {
			int index = indexes[h];
			List<Entry> list = data.get(index);
			for (Entry entry : list) {
				if (key.equals(entry.getKey())) {
					// found
					return entry.getValue();
				}
			}
		}

		return null;
	}

	public int size() {
		return size;
	}

	public void put(String key, Object value) {
		int h = hash(key);
		Entry entry = new Entry(key, value);

		if (indexes[h] == null) {
			int index = data.size();
			indexes[h] = index;
			LinkedList<Entry> list = new LinkedList<Entry>();
			list.add(entry);
			data.add(list);
		} else {
			int index = indexes[h];
			List<Entry> list = data.get(index);
			list.add(entry);
		}

		size++;
	}

	public void remove(String key) {
		int h = hash(key);

		if (indexes[h] != null) {
			int index = indexes[h];
			List<Entry> list = data.get(index);
			for (ListIterator<Entry> i = list.listIterator(); i.hasNext();) {
				Entry entry = i.next();
				if (key.equals(entry.getKey())) {
					// found
					i.remove();
				}
			}
			
			if (list.size() == 0) {
				data.remove(index);
			}
		}
	}

	public static void main(String[] args) {
		HashTable table = new HashTable();

		table.put("key1", "value of key1");
		table.put("key2", "value of key2");
		table.put("key3", "value of key3");

		System.out.println(table.size());
		System.out.println(table.get("key1"));
		System.out.println(table.get("key3"));
		System.out.println(table.get("key2"));
		System.out.println(table.get("key"));
		
		table.remove("key2");
		
		for (int i = 0; i < 120; i++) {
			table.put("key" + i, i);
		}
	}

	private static class Entry {
		private String key;
		private Object value;

		public Entry(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}
}
