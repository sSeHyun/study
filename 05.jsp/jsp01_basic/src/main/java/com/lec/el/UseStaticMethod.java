package com.lec.el;

import java.text.DecimalFormat;

public class UseStaticMethod {
	
	public static String numberFormat(long number,String pattern) {
		
		DecimalFormat ptrn=new DecimalFormat(pattern);
		return ptrn.format(number);
		
	}
}
