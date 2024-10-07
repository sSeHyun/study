package ex03_channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelMain2 {

	public static void main(String[] args) throws Exception {
		
		Path path = Paths.get("d:/temp/함수.text");
		
		// 1. FileChannel생성
		FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
		
		// 2. 파일읽기
		ByteBuffer buffer = ByteBuffer.allocate(200);
		Charset cs = Charset.defaultCharset();
		
		String data = "";
		int byteCount = 0;
		
		while(true) {
			byteCount = fc.read(buffer);
			if(byteCount == -1) break;
			buffer.flip();
			data += cs.decode(buffer).toString();
			buffer.clear();			
		}
		System.out.println(data);
		
		// 3. 닫기
		fc.close();
	}

}

















