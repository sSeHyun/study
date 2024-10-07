package ex04_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.*;

public class WriterMain {

	public static void main(String[] args) throws Exception {
		
		//1. write(int c)
		Writer writer=new FileWriter("src/ex04_writer/test1.text");
		
		char[] data="대한민국만세".toCharArray();
		for(int i=0;i<data.length;i++) {
			writer.write(data[i]);
		}
		writer.flush();
		writer.close();
		
		//2. write(char cbuf[],int off,int len)
		writer=new FileWriter("src/ex04_writer/test2.text");
		data="우리나라만세".toCharArray();
		writer.write(data, 1, 2);
		writer.flush();
		writer.close();

	}

}
