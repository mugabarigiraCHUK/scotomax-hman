package com.itap.callcenter.utile;

public class Utils {

	public static boolean isEmpty(String val) {
		if ( val == null ) return true;
		if (val.trim().length() == 0) return true;
		return false;
	}
	
	public static boolean isDigit(String val) {
		if ( val == null ) return false;
		if (val.trim().length() == 0) return false;
		for ( char ch : val.toCharArray() ) {
			if ( !Character.isDigit(ch) ) return false;
		}
		return true;
	}
}
