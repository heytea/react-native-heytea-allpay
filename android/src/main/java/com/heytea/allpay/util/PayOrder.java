package com.heytea.allpay.util;

import java.io.Serializable;

public class PayOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String orderNum;
	public String orderAmount;
	public String orderCurrency;
	public String backURL;
	public String merID;
	public String secretKey;
	public String  paymentSchema;
	public String  version;
	public String charSet;
	public String transType;
	public String frontURL;
	public String merReserve;
	public String acqID;
	public String transTime;
	public String OrderDesc;
	public String signType;
	public String signature;
	public String language;
	public String customerId;
	
}
