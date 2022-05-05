package test.kh0503;
// 데이터만 담을 수  있는 클래스 설계하기
// 접두어에 사용된 VO는 Value Object의 약자 이다.
// 자바의 변수와 오라클의 변수 사이에 매칭해주는 클래스 설계이름이다.
public class UserVO {
	// 아이디를 담을 변수 선언
	private String mem_id;
	// 비번을 담을 변수 선언
	private String mem_pw;
	// 그 사용자의 생일을 담을 변수 선언
	private String birth;
	// 디폴트 생성자 - 파라미터가 하나도 없는 그런 생성자
	// 역할 : 니가 있어서 내가 RAM(H/W)에 올라 탈수 있어-재사용하려고
	// 전변을 재사용하기 위해서는 생성자를 반드시 호출 할것
	// 지금까지는 않해도 문제가 없었잖아요
	public UserVO() {}
	// 세 개의 파라미터를 갖는 생성자를 통해서 전역변수의 초기화가 가능함.
	public UserVO(String mem_id, String  mem_pw, String birth) {
		//this가 붙은 mem_id만 전변, this가 없는 변수는 지변(위치:파라미터)
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.birth = birth;
	}
	public String getMem_id() {
		return mem_id;
	}
	// 접근제한자가 public이므로 외부에서 접근 가능하다
	// 파라미터를 통해서 값이 전달되고 전변인 mem_id
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
