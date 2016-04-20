package org.apache.play.domain;

import java.math.BigInteger;


public class BigIntegerResult implements IResult {
	
	private BigInteger data;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6341178866833795484L;

	public BigIntegerResult(BigInteger data){
		this.data = data;
	}

	public BigInteger getData() {
		return data;
	}

}
