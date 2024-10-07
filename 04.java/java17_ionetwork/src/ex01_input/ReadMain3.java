package ex01_input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadMain3 {

	public static void main(String[] args) throws Exception {
		//3. read(byte[] b)
		InputStream is =new FileInputStream("src/ex01_input/news.text");

		int readByte;
		byte[] readBytes=new byte[3];
		
		readByte=is.read(readBytes);
		
		for(int i=0;i<readBytes.length;i++) {
			System.out.println((char) readBytes[i]);
		}
		is.close();
	}

}
