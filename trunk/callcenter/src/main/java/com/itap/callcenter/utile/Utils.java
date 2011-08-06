package com.itap.callcenter.utile;

/**
 * 
 * @author scotomax
 *
 */
public class Utils {

	/**
	 * Validate val, Is it empty?
	 * @param val
	 * @return true when the val is empty otherwise is false.
	 */
	public static boolean isEmpty(String val) {
		if ( val == null ) return true;
		if (val.trim().length() == 0) return true;
		return false;
	}
	
	/**
	 * Validate val, Is it number character only?
	 * @param val
	 * @return true when the val is number character only otherwise is false.
	 */
	public static boolean isDigit(String val) {
		if ( val == null ) return false;
		if (val.trim().length() == 0) return false;
		for ( char ch : val.toCharArray() ) {
			if ( !Character.isDigit(ch) ) return false;
		}
		return true;
	}
}
