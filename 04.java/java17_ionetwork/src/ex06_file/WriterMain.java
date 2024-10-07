package ex06_file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterMain {

	public static void main(String[] args) throws Exception {
		
		File file=new File("d:/temp/함수.text");
		FileWriter fw=new FileWriter(file,false);
		
		fw.write("ㅂㅈㄷㄱㅄㅂㅁㄴㅇ러ㅣㅁ쉬어봐요\n");
		fw.write("ㅁㄴㅇ러ㅣㅁ;ㄴ\n");
		fw.write("ㅁㄴㅇㄹㄱㅄㅂㅁㄴㅇ러ㅣㅁ;ㄴ\n");
		fw.flush();
		fw.close();
		System.out.println("파일이 성공적으로 저장이 되었습니다!");

	}

}
