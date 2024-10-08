package ex02_board;

import java.util.ArrayList;

public interface BoardDAOService {

	void createBoard(); // 1. 글쓰기
	ArrayList<BoardVO> listBoard(); // 2. 글목록
	BoardVO viewBoard(); // 3. 글조회
	void updateBoard(); // 4. 글수정
	void deleteBoard(); // 5. 글삭제
	
	ArrayList<BoardVO> findBySubjectBoard();// 6. 검색기능 by 제목
	ArrayList<BoardVO> findByWriterBoard(); // 7. 검색기능 by 작성자
}
