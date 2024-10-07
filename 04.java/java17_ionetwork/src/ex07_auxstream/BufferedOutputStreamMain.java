package ex07_auxstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedOutputStreamMain {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		long start, end;
		int data = -1;
		
		// 1. non-buffer
		fis = new FileInputStream("src/ex06_file/blackpink_02.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("src/ex07_auxstream/blackpink_fos.jpg");

		start = System.nanoTime();
		
		while((data = bis.read()) != -1) {
			fos.write(data);
		}
		
		end = System.nanoTime();
		System.out.println("버퍼를 사용하지 않았을 경우 소요시간 = " + (end-start) + "ns");	
		
		// 2. buffer
		fis = new FileInputStream("src/ex06_file/blackpink_02.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("src/ex07_auxstream/blackpink_bos.jpg");	
		bos = new BufferedOutputStream(fos);
		

		start = System.nanoTime();
		
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		
		end = System.nanoTime();
		System.out.println("버퍼를 사용했을 경우 소요시간 = " + (end-start) + "ns");	
	}

}
