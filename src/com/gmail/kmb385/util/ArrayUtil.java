package com.gmail.kmb385.util;


public class ArrayUtil {

	/* This is starting to become my own array utils class */
	public static String[] prefixArray(String[] arr, String prefix) {
		String[] tmpArr = arr.clone();
		for (int i = 0; i < tmpArr.length; i++) {
			tmpArr[i] = prefix +  tmpArr[i];
		}
		return tmpArr;
	}
	
	public static String[] suffixArray(String[] arr, String[] suffixes) {
		if(arr.length != suffixes.length){
			throw new RuntimeException("Error: Arrays supplied for suffix were of unequal length");
		}
		
		String[] tmpArr = arr.clone();
		for (int i = 0; i < tmpArr.length; i++) {
			tmpArr[i] = tmpArr[i] + suffixes[i];
		}
		
		return tmpArr;
	}

	public static String joinArray(String[] arr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i != arr.length - 1) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}
	
}
