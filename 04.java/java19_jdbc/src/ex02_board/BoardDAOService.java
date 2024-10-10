package ex02_board;

import java.util.ArrayList;

public interface BoardDAOService {

	void createBoard(); // 1. 글쓰기
	ArrayList<BoardVO> listBoard(); // 2. 글목록
	BoardVO viewBoard(int bno); // 3. 글조회
	void updateBoard(int bno); // 4. 글수정
	void deleteBoard(int bno);
	
	ArrayList<BoardVO> findBySubjectBoard(String subject);// 6. 검색기능 by 제목
	ArrayList<BoardVO> findByWriterBoard(String writer); // 7. 검색기능 by 작성자
	
}
