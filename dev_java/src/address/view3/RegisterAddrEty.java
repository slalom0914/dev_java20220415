package address.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterAddrEty {
	DBConnectionMgr 	dbMgr	= new DBConnectionMgr();
	Connection 			con		= null;
	PreparedStatement 	ps 		= null;
    /****************************************************************************
     * 회원등록 구현
	   INSERT INTO mkaddrtb(id, name, address, telephone
                          , gender, relationship, birthday
                          , comments, registedate)
                     values(11,'나신입','서울시 강남구 대치동','0105557777'
                           ,1, '회사동료', '1999-10-27'
                           ,'Front-End개발자', '2022-04-16')
     * @param vo - 사용자가 입력한 값 담기
     * @return - 등록 성공 여부 담기
     ***************************************************************************/
	public AddressVO register(AddressVO vo) {
		System.out.println("RegisterAddrEty register 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO mkaddrtb ");
		sql.append(" (name, address, telephone, gender, relationship, ");
		sql.append("  birthday, comments, registedate, id) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, seq_mkaddrtb_id.nextval)");
		try {
			con = dbMgr.getConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getAddress());
			ps.setString(3, vo.getTelephone());
			ps.setString(4, vo.getGender());
			ps.setString(5, vo.getRelationship());
			ps.setString(6, vo.getBirthday());
			ps.setString(7, vo.getComments());
			ps.setString(8, vo.getRegistedate());
			if(ps.executeUpdate() < 1) {
				String msg = "데이터 입력에 실패했습니다.";
				System.out.println(msg);
			} else {
				System.out.println("데이터 입력에 성공했습니다.");
				vo.setResult(1);
			}
		} catch(SQLException e) {
			String msg = "데이터 입력에 실패했습니다.";
			System.out.println(msg + "\r\n" + e);
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(SQLException e) {}
		}		
		return vo;
	}////////////////////// end of register

}////////////////////////// end of RegisterAddrEty


/*
INSERT INTO mkaddrtb(name, address, telephone, gender, relationship
,birthday, comments, registedate, id)
VALUES ('나신입', '서울시 영등포구 당산동', '010-555-7777'
, '1', 'JAVA과정동기', '19900712', '백엔드개발자', '20220325', seq_mkaddrtb_id.nextval)

SELECT * 
FROM mkaddrtb
WHERE id=13  

delete from mkaddrtb
where id=11 

commit        



CREATE SEQUENCE HR.SEQ_MKADDRTB_ID
START WITH 11
MAXVALUE 99999
MINVALUE 10
NOCYCLE
NOCACHE
NOORDER;

*/