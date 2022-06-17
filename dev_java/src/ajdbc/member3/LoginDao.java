package ajdbc.member3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import address.view2.DBConnectionMgr;

public class LoginDao {
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	public String login(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	/*************************************************************************
	 * 아이디 중복체크 구현하기
	 * @param 사용자가 입력한 아이디
	 * @return boolean
	 * 만일 boolean을 선택했다면 false이면 사용할 수 없다.  true이면 사용할 수 있다.
	 * 만일 boolean을 선택했다면 false이면 사용할 수 있다.  true이면 사용할 수 없다.
	SELECT 1
	  FROM dual
	 WHERE EXISTS (SELECT mem_name
	                 FROM member
	                WHERE mem_id ='tomato') 
	 질문 1: tomato가 존재하는데 false가 뜹니다. 뭐가 문제인가요?
	 질문 2: java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1 일때
	        ?자리에 들어갈 값을 치환하지 않은 경우
	 질문 3: 토드에서 사용한 변수를 그대로 사용한 경우 반드시 ?로 바꾸어 쓸 것.
	 질문 4: java.sql.SQLSyntaxErrorException: ORA-00911: 문자가 부적합합니다
	       쿼리문 뒤에 세미콜론을 붙인 경우에 발생하는 오류 입니다.                       
	*************************************************************************/                
	public boolean idCheck(String user_id) {
		boolean isOk = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT 1                               ");
		sql.append("  FROM dual                            ");
		sql.append(" WHERE EXISTS (SELECT mem_name         ");
		sql.append("                 FROM member           ");
		sql.append("                WHERE mem_id =?)"); 	
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반드시 반납할 것. - 자바 튜닝팀 지적사항
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return isOk;
	}///////////////////////// end of idCheck

}
