package org.apache.play.domain;


public class LongResult implements IResult {
	
	private Long data;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1061449957155392958L;
	
	public LongResult(Long data){
		this.data = data;
	}

	public Long getData() {
		return data;
	}

}
