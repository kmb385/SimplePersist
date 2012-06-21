package com.gmail.kmb385.samples;

import com.gmail.kmb385.annotations.Column;
import com.gmail.kmb385.annotations.Table;

@Table(name="item")
public class Item {

	@Column(name="itemId")
	private int itemId;
}
