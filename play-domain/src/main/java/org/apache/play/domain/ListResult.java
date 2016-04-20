package org.apache.play.domain;

import java.util.List;


public class ListResult<T> implements IResult {
	private List<T> data;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7602593878605710987L;
	public ListResult(List<T> data){
		this.data =data;
	}
	public List<T> getData() {
		return data;
	}
	
}
