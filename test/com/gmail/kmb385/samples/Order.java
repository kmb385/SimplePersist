package com.gmail.kmb385.samples;

import java.math.BigDecimal;
import java.util.Date;

import com.gmail.kmb385.annotations.Column;
import com.gmail.kmb385.annotations.PrimaryKey;
import com.gmail.kmb385.annotations.Table;

@Table(name="ORDER")
public class Order {
	
	@PrimaryKey
	@Column(name="ORDER_ID")
	int orderId;

	@Column(name="CREATED_DT")
	Date createdDt;
	
	@Column(name="MY_NUMBER")
	Number myNumber;
	
	@Column(name="MY_DECIMAL")
	BigDecimal myDecimal;
}
