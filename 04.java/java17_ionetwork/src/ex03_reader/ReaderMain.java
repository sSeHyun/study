package ex03_reader;
import java.io.*;
/*
	Reader
	
	Reader는 문자기반의 입력스트림의 최상위클래스이다. 모든 문자기반 입력스트림 FileReader,
	BufferedReader, InputStreamReader는 모두 Reader클래스를 상속한다.
	
	Reader클래스의 주요메서드는
	
	1. read() : 입력스트림으로 부터 한개의 문자를 읽고 리턴
	2. read(char[] c) : 읽은 문자를 문자배열 c에 저장하고 실제 읽은 문자를 리턴
	3. read(char[] c, int off, int len) : 읽은 문자를 c에 저장하고 off~len개의 문자를 읽고 읽은 문자를 리턴
	4. close() : 사용한 자원을 해제
*/
public class ReaderMain {

	public static void main(String[] args) throws Exception {
		Reader reader=new FileReader("src/ex01_input/news.text");
		
		//1. read()
		int readData;
		while(true) {
			readData=reader.read();
			if(readData==-1) break;
			System.out.println(readData+"="+(char) readData);
		}
		reader.close();
		System.out.println("-".repeat(50));
		
		//2. read(char[] c)
		reader = new FileReader("src/ex01_input/news.text");
		int readCharNum;
		char[] cbuf = new char[2];
		String data = "";
		
		while(true) {
			readCharNum = reader.read(cbuf);
			if(readCharNum == -1) break;
			data += new String(cbuf, 0, readCharNum);
		}
		System.out.println(data);
		reader.close();
		System.out.println("-".repeat(50));
		
		
		//3. read(char[] c,int off, int len)
		reader = new FileReader("src/ex01_input/news.text");
		int readNum;
		char[] cbuf2=new char[8];
		
		readNum = reader.read(cbuf2, 1, 4);
		for(int i=0;i<cbuf2.length;i++) {
			System.out.println(cbuf2[i]);
		}
		reader.close();


	}

}
