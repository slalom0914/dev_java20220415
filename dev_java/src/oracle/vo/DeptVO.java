package oracle.vo;

public class DeptVO {
	// 변수의 접근 제한자는 private으로 한다.
	// 동시에 많은 사람들이 접속하여 서로 다른 정보를 유지해야 하고
	// 그 개인 정보가 위변조 되는 것을 방지함
	private int    deptno =0;// 부서번호
	private String dname  ="";// 부서명
	private String loc    ="";// 지역
	// dept테이블에 있는 컬럼은 아니지만 MVC패턴 적용시
	// 사용자의 요청을 분기하는 목적으로 필요한 변수 이다.
	private String command = "";
	// 오라클 서버에 입력,수정,삭제 요청 후 돌려받는 값 담기
	private int	   result  = 0;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}
