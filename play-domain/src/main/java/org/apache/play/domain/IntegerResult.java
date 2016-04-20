package org.apache.play.domain;


public class IntegerResult implements IResult {
	
	private Integer data;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7161017968032183447L;

	public IntegerResult(Integer data){
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

}
