package ex01_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {

	public static void main(String[] args) throws Exception {
		
		// 3. 파일속성읽기 및 파일,폴더생성/삭제
		Path path = Paths.get("src/ex01_file/NIOMain.java");
		
		System.out.println("[디렉토리여부]\t" + Files.isDirectory(path));
		System.out.println("[파일여부]\t" + Files.isRegularFile(path));
		System.out.println("[마지막수정시간]\t" + Files.getLastModifiedTime(path));
		System.out.println("[파일크기]\t" + Files.size(path));
		System.out.println("[소유자]\t" + Files.getOwner(path).getName());
		System.out.println("[숨김파일]\t" + Files.isHidden(path)); 
		System.out.println("[읽기가능]\t" + Files.isReadable(path));
		System.out.println("[쓰기가능]\t" + Files.isWritable(path));
	}
}
