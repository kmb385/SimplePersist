package com.gmail.kmb385.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void joinArrayTest() {
		String[] arr = { "This", "is", "a", "test" };
		String delimiter = ",";
		
		String result = ArrayUtil.joinArray(arr, delimiter);
		assertEquals("This,is,a,test", result);
	}

	@Test
	public void prefixArrayTest() {
		String[] arr = { "This", "is", "a", "test" };
		String prefix = ":";
		
		String[] results = ArrayUtil.prefixArray(arr, prefix);
		
		assertNotNull(results);
		assertEquals(arr.length, results.length);
		
		for(int i = 0; i < arr.length; i++){
			assertEquals(prefix +arr[i], results[i]);
		}
	}
	
	@Test
	public void suffixArrayTest(){
		String[] arr = { "This", "is", "a", "test" };
		String[] suffixes = { " surely ", " not ", " valid ", ", right?" };
		
		String[] results = ArrayUtil.suffixArray(arr, suffixes);
		
		assertNotNull(results);
		assertEquals(arr.length, results.length);
		assertEquals("This surely is not a valid test, right?", ArrayUtil.joinArray(results, ""));

	}

}
