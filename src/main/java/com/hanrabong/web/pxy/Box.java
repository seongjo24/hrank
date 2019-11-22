package com.hanrabong.web.pxy;

import java.util.ArrayList;

public class Box<T> extends CrawlingProxy{
	ArrayList<T> list;
	
	public void add(T item) {
		list = new ArrayList<>();
		list.add(item);
	}
	
	public T get(int i) {
		return list.get(i);
	}
	
	public ArrayList<T> getList(){
		return list;
	}
	
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
	
	public void clear() {
		list.clear();
	}
	

}
