package ex02_kind;

import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FromFileMain {

	public static void main(String[] args) throws IOException {
		
		//4. 파일로부터 stream을 얻기
		Stream<String> stream=null;
		
		//1) 파일 경로
		Path path=Paths.get("D:\\sena\\04.java\\java16_stream\\src\\ex02_kind\\data.txt");
		System.out.println(path);
		System.out.println();
		
		//2) 파일읽기
		stream=Files.lines(path,Charset.defaultCharset());
		stream.forEach(System.out::println);
		System.out.println();
		
		//3) 파일읽기(2)
		File file = path.toFile();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		stream = br.lines();
		stream.forEach(System.out :: println);
		System.out.println();
		br.close();
		fr.close();

	}

}
