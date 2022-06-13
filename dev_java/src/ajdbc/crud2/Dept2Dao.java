package ajdbc.crud2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

import address.view2.DBConnectionMgr;
import ajdbc.crud.DeptView;
import oracle.vo.DeptVO;

public class Dept2Dao {
	Dept2View deptView = null;
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	// 디폴트 생성자는 생성자가 하나도 없을 경우에만 제공됨
	// 파라미터를 갖는 생성자가 하나라도 있으면 디폴트 생성자도 제공안됨
	public Dept2Dao() {}
	public Dept2Dao(Dept2View deptView) {
		this.deptView = deptView;
	}
	/*******************************************************************
	 * 부서 등록 구현
	 * VO(Value Object) - 오라클 타입과 자바타입비교 - 컬럼명과 VO전변과 Map의 키값은 반드시 일치해야 한다.
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다 - 복합데이터 클래스
	 * @return int  - 1:등록 성공 0: 등록 실패
	 * INSERT INTO dept(deptno, dname, loc)
                 VALUES(71,'개발1팀','서귀포')
	 *******************************************************************/
	public int deptInsert(DeptVO pdVO) {
		System.out.println("deptInsert 호출 성공");
		int result = 0;
		//insert here
		
		return result;
	}
	/*******************************************************************
	 * 부서 수정 구현
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다 - 복합데이터 클래스
	 * @return int  - 1:등록 성공 0: 등록 실패
	 * UPDATE dept
          SET dname = '개발2팀'
             ,loc = '거제도'      
        WHERE deptno = 71
	 *******************************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 성공");	
		int result = 0;
		//insert here
		
		return result;
	}
	/*******************************************************************
	 * 부서 삭제 구현
	 * @param deptno(int) - 사용자가 선택한 부서번호
	 * @return int  - 1:등록 성공 0: 등록 실패
	 * DELETE FROM dept
        WHERE deptno = 71  
	 *******************************************************************/
	public int deptDelete(int deptno) {
		System.out.println("deptDelete 호출 성공 : "+ deptno);
		int result = 0;
		// insert here
		
		return result;
	}
	/********************************************************************
	 * 부서 목록 전체 조회 구현(새로고침시 재사용 위해서)
	 * @return List<Map<String,Object>>
	 * SELECT deptno, dname, loc FROM dept
	 ********************************************************************/
	public List<Map<String,Object>> deptSelectAll(){
		System.out.println("deptSelectAll 호출 성공");		
		List<Map<String,Object>> deptList = new ArrayList<>();
		// insert here
		
		return deptList;
	}
	/********************************************************************
	 * 부서 상세 조회 구현
	 * @param deptno(int)
	 * @return DeptVO
	 * SELECT deptno, dname, loc FROM dept
	 *  WHERE deptno = ?
	 ********************************************************************/
	public DeptVO deptSelectDetail(int deptno){
		System.out.println("deptSelectDetail 호출 성공");
		DeptVO rdVO = null;
		// insert here
		
		return rdVO;
	}	
}
