package demo;

import java.util.ArrayList;
import java.util.List;

import demo.Table.Row;

public record Table<T>(List<Row<T>> rows) {

	public static record Row<T>(List<T> values) {
		
		public Row(List<T> values){
			if (values == null) {
				throw new IllegalArgumentException("Values must not be null!");
			}
			this.values = new ArrayList<>(values);
		}
		
		public T valueAt(int index) {
			return values.get(index);
		}
	}
	
	public Table(List<Row<T>> rows) {
		if (rows == null) {
			throw new IllegalArgumentException("Rows must not be null!");
		}
		this.rows = new ArrayList<>(rows);
	}
	
	public Row<T> rowAt(int index) {
		if (index >= rows.size()) {
			return null;
		}
		return rows.get(index);
	}
	public void add(Row<T> row) {
		if (row == null) {
			throw new IllegalArgumentException("Row must not be null!");
		}
		this.rows.add(row);
	}
	
}
