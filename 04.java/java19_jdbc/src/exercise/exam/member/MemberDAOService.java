package exercise.exam.member;

import java.util.ArrayList;

public interface MemberDAOService {
	
	void createMember();
	ArrayList<MemberVO> listMember();
	MemberVO viewMember(int member_id);
	void updateMember(int member_id);
	void deleteMember(int member_id);
	
	ArrayList<MemberVO> findByNameMember(String member_name);
	ArrayList<MemberVO> findByEmailMember(String member_email);

}
