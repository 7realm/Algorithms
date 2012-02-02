package algo.data.table.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Assert;

import algo.data.table.Entry;
import algo.data.table.Table;

public class LinkedHashTable implements Table {
	private int size = 0;
	private int capacity = 100;
	private Integer[] indexes = new Integer[capacity];
	private List<LinkedList<Entry>> data = new LinkedList<LinkedList<Entry>>();

	private int hash(Object key) {
		int code = key.hashCode();

		return (int) (Math.abs(code) / 2f / Integer.MAX_VALUE * capacity);
	}

	@Override
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

	@Override
	public int size() {
		return size;
	}

	@Override
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

	@Override
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
					size--;
				}
			}

			if (list.size() == 0) {
				data.remove(index);
			}
		}
	}
}
