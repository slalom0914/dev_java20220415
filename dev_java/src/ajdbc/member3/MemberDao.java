package ajdbc.member3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import address.view2.DBConnectionMgr;
import oracle.vo.MemberVO;

public class MemberDao {
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	public int memberInsert(Member3VO pmVO) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO member(mem_no,mem_id,mem_pw,mem_name,mem_zipcode,mem_address)");
		sql.append("VALUES(seq_member_no.nextval,?,?,?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, pmVO.getMem_id());
			pstmt.setString(++i, pmVO.getMem_pw());
			pstmt.setString(++i, pmVO.getMem_name());
			pstmt.setString(++i, pmVO.getMem_zipcode());
			pstmt.setString(++i, pmVO.getMem_address());
			result = pstmt.executeUpdate();
			pmVO.setResult(result);
			System.out.println("result : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		return result;
	}

}
