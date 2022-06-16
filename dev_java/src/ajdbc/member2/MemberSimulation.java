package ajdbc.member2;

import oracle.vo.MemberVO;

public class MemberSimulation {

	public static void main(String[] args) {
		Member2Ship ms = new Member2Ship();
		//boolean isOk = ms.idCheck("tomato");
		//System.out.println(isOk);
		MemberVO pmVO = new MemberVO();
		pmVO.setMem_id("test");
		pmVO.setMem_pw("123");
		pmVO.setMem_name("강감찬");
		pmVO.setMem_zipcode("123456");
		pmVO.setMem_address("서울시 영등포구 당산동");
		int result = ms.memberInsert(pmVO);
		System.out.println("result ==> "+result);//1이면 입력 성공임
	}

}
