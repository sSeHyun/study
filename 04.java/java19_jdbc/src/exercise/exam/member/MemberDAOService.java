package exercise.exam.member;

import java.util.ArrayList;

public interface MemberDAOService {
	void createMember();
	ArrayList<MemberVO> listMember();
	void viewMember();
	void updateMember();
	void deleteMember();
	
	ArrayList<MemberVO> findByNameMember();
	ArrayList<MemberVO> findByEmailMember();

}
