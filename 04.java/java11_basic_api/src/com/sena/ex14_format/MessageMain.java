package com.sena.ex14_format;

import java.text.MessageFormat;

public class MessageMain {

	public static void main(String[] args) {
		
		String id = "hong";
		String name = "홍길동";
		String tel = "010.9999.8888";

		String text = "회원ID={0}, 회원이름={1}, 전화번호={2}";
		String result1 = MessageFormat.format(text, id, name, tel);
		System.out.println(result1);
	}

}
