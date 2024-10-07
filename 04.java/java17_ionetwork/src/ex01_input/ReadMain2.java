package ex01_input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadMain2 {

	public static void main(String[] args) throws Exception {
		InputStream is =new FileInputStream("src/ex01_input/news.text");
		
		int readByte;
		String data="";
		
		byte[] readBytes=new byte[3];
		
		while(true) {
			readByte=is.read(readBytes);
			if(readByte==-1) break;
			//System.out.println(new String(readBytes,0,readByte));
			data+=new String(readBytes,0,readByte);
		}
		System.out.println(data);
		is.close();

	}

}
