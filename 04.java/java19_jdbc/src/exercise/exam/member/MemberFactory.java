package exercise.exam.member;

public class MemberFactory {
	private MemberFactory() {}
	private static MemberDAOImpl mbdao=null;
	public static MemberDAOImpl getInstance() {
		if(mbdao==null) mbdao=new MemberDAOImpl();
		return mbdao;
		
	}
	

}
