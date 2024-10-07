package ex02_output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;


/*
	OutputStream
	
	OutputStream은 바이트기반 출력스트림의 최상위 추상클래스이다. 모든 바이트기반 출력스트림
	FileOutputStream, PrintOutputStream, BufferedOutputStream, DataOutputStream은 모두 OutputStream
	을 상속한다.
	
	OutputStream의 주요메서드는
	
	1. write(int byte) : 1byte씩 출력
	2. write(byte[] b) : 매개값으로 주어진 배열의 바이트 수 만큼 출력
	3. write(byte[] b, int off, int len) : b의 off~len까지의 바이트수 만큼 출력
	4. flush() : 버퍼에 잔류한 바이트 전부를 출력
	5. close() : 사용된 자원을 메모리에서 해제
*/		
public class WriteMain {

	public static void main(String[] args) throws Exception {

		OutputStream os = new FileOutputStream("src/ex02_output/test1.txt");

		// 1. write(int byte)
		byte[] data = "대한민국만세".getBytes();
		System.out.println(data.toString());
		for(int i=0;i<data.length;i++) {
			os.write(data[i]);
		}
		os.flush();
		os.close();
				
		// 2. write(byte[] b)
		os=new FileOutputStream("src/ex02_output/test2.txt");
		data="1234567890".getBytes();
		os.write(data);
		os.close();
		
		// 3. write(byte[] b, int off, int len)
		os=new FileOutputStream("src/ex02_output/test3.txt");
		data="1234567890".getBytes();
		os.write(data,1,3);
		os.close();
		
		//실습. WriteMain.java를 test4.text로 출력해보기
		
		InputStream is=new FileInputStream("src/ex02_output/WriteMain.java");
		
		byte[] readBytes=new byte[3];
		int readByte=is.read(readBytes);
		for(int i=0;i<readBytes.length;i++) {
			System.out.println((char)readBytes[i]);
		}
		
		is.close();
		
		os=new FileOutputStream("src/ex02_output/test4.txt");
		//data=is.getBytes();
		os.write(data);
		os.close();
		
	}

}

















