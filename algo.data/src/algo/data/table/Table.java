package algo.data.table;

public interface Table {

	public abstract Object get(String key);

	public abstract int size();

	public abstract void put(String key, Object value);

	public abstract void remove(String key);

}