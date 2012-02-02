package algo.data.table.impl;

import java.util.Random;

import algo.data.table.Table;

public class SimpleHashTable implements Table {
	private int size = 0;
	private int capacity = 99;
	private Object[] data = new Object[capacity];

	private int hash(String key) {
		int code = key.hashCode();
		return (int) (Math.abs(Math.cos(code)) * capacity);
	}

	@Override
	public Object get(String key) {
		return data[hash(key)];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void put(String key, Object value) {
		data[hash(key)] = value;
		size++;
	}

	@Override
	public void remove(String key) {
		data[hash(key)] = null;
		size--;
	}
}
